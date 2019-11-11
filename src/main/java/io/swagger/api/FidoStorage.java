package io.swagger.api;

import com.yubico.webauthn.CredentialRepository;
import com.yubico.webauthn.RegisteredCredential;
import com.yubico.webauthn.data.ByteArray;
import com.yubico.webauthn.data.PublicKeyCredentialDescriptor;

import java.util.*;
import java.util.Map.Entry;

public class FidoStorage implements CredentialRepository {
    // Store data in local variables for now.
    Map<String, RegisteredCredential> registeredCredentialByUsername = new HashMap<String, RegisteredCredential>();

    // I want to associate a credential name to a credential ID that is registered (stored).
    Map<String, String> registeredCredentialNameByUsername = new HashMap<String, String>();

    @Override
    public Set<PublicKeyCredentialDescriptor> getCredentialIdsForUsername(String username) {
        if (this.registeredCredentialByUsername.containsKey(username)) {
            Set<PublicKeyCredentialDescriptor> credentialIdForUsername = new HashSet<PublicKeyCredentialDescriptor>();
            credentialIdForUsername.add(PublicKeyCredentialDescriptor.builder()
                    .id(this.registeredCredentialByUsername.get(username).getCredentialId())
                    .build()
            );

            return credentialIdForUsername;
        } else {
            return new HashSet<PublicKeyCredentialDescriptor>();
        }
    }

    @Override
    public Optional<ByteArray> getUserHandleForUsername(String username) {
        if (this.registeredCredentialByUsername.containsKey(username)) {
            Optional<ByteArray> userHandleMaybe = Optional.of(this.registeredCredentialByUsername.get(username).getUserHandle());
            return userHandleMaybe;
        } else {
            return null;
        }
    }

    @Override
    public Optional<String> getUsernameForUserHandle(ByteArray userHandle) {
        Optional<String> sUsernameMaybe = null;
        Iterator<Entry<String, RegisteredCredential>> it = this.registeredCredentialByUsername.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, RegisteredCredential> nextRegisteredCredential = it.next();
            if (Arrays.equals(nextRegisteredCredential.getValue().getUserHandle().getBytes(), userHandle.getBytes())) {
                sUsernameMaybe = Optional.of(nextRegisteredCredential.getKey());
                break;
            }
        }

        return sUsernameMaybe;
    }

    @Override
    public Optional<RegisteredCredential> lookup(ByteArray credentialId, ByteArray userHandle) {
        Optional<RegisteredCredential> registeredCredentialMaybe = null;
        Iterator<Entry<String, RegisteredCredential>> it = this.registeredCredentialByUsername.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, RegisteredCredential> nextRegisteredCredential = it.next();
            if (Arrays.equals(nextRegisteredCredential.getValue().getCredentialId().getBytes(), credentialId.getBytes()) && Arrays.equals(nextRegisteredCredential.getValue().getUserHandle().getBytes(), userHandle.getBytes())) {
                registeredCredentialMaybe = Optional.of(nextRegisteredCredential.getValue());
                break;
            }
        }

        return registeredCredentialMaybe;
    }

    @Override
    public Set<RegisteredCredential> lookupAll(ByteArray credentialId) {
        Set<RegisteredCredential> credentialIdForUsername = new HashSet<RegisteredCredential>();
        Iterator<Entry<String, RegisteredCredential>> it = this.registeredCredentialByUsername.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, RegisteredCredential> nextRegisteredCredential = it.next();
            if (Arrays.equals(nextRegisteredCredential.getValue().getCredentialId().getBytes(), credentialId.getBytes())) {
                credentialIdForUsername.add(nextRegisteredCredential.getValue());
                break;
            }
        }

        return credentialIdForUsername;
    }

    public boolean saveRegistration(String sUsername, String sCredentialNickname, RegisteredCredential registeredCredential) {
        boolean bDidSave = true;
        if (!this.registeredCredentialByUsername.containsKey(sUsername)) {
            this.registeredCredentialByUsername.put(sUsername, registeredCredential);
            this.registeredCredentialNameByUsername.put(sUsername, sCredentialNickname);
        } else {
            bDidSave = false;
        }

        return bDidSave;
    }
}