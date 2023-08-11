package com.marat.front.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String remoteLogin();
    String remotePassword();
    String remoteUrl();
}
