/*
 * (C) Copyright 2016 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.nuxeo.ecm.platform.importer.queue.producer;

import org.nuxeo.ecm.platform.importer.log.ImporterLogger;
import org.nuxeo.ecm.platform.importer.queue.AbstractTaskRunner;
import org.nuxeo.ecm.platform.importer.queue.manager.QueuesManager;
import org.nuxeo.ecm.platform.importer.source.SourceNode;

/**
 * @since 8.3
 */
public abstract class AbstractProducer extends AbstractTaskRunner implements Producer {

    protected ImporterLogger log = null;

    protected QueuesManager qm;

    public AbstractProducer(ImporterLogger log) {
        this.log = log;
    }

    @Override
    public void init(QueuesManager qm) {
        this.qm = qm;
    }

    protected void dispatch(SourceNode node) throws InterruptedException {
        qm.dispatch(node);
        incrementProcessed();
    }

}