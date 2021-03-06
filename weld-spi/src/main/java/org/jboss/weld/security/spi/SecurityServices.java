/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.security.spi;

import java.security.Principal;

import org.jboss.weld.bootstrap.api.Service;

/**
 * Responsible for accessing security related functionality the environment can provide.
 *
 * Required in a Java EE environment.
 *
 * {@link SecurityServices} is a per-deployment service.
 *
 * @author pmuir
 * @author Jozef Hartinger
 *
 */
public interface SecurityServices extends Service {

    /**
     * Obtain the Principal representing the current caller identity
     *
     * @return the Principal representing the current caller identity
     */
    Principal getPrincipal();

    /**
     * Obtain the security context associated with the current thread.
     * This method is used by Weld to propagate the security context of the current thread
     * to different threads.
     *
     * TODO: this method is temporarily default with noop fallback implementation to make migration easier. Make the implementation required later.
     *
     * @return the security context associated with the current thread
     */
    default SecurityContext getSecurityContext() {
        return SecurityContext.NOOP_SECURITY_CONTEXT;
    }

}
