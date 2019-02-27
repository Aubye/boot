package org.orgin.annotations.proxy;

import org.orgin.proxy.ProxyChain;

public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
