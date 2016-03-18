/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.datamapper.engine.core.executors;

import org.wso2.datamapper.engine.core.Executable;
import org.wso2.datamapper.engine.core.executors.nashorn.NasHornJava8Executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ScriptExecutorPool {

    private BlockingQueue<Executable> executors;

    public ScriptExecutorPool(ScriptExecutorType executorType, int executorPoolSize) {
        executors = new LinkedBlockingQueue<>();
        for (int i = 0; i < executorPoolSize; i++) {
            Executable executor = createScriptExecutor(executorType);
            if (executor != null) {
                executors.add(executor);
            }
        }
    }

    private Executable createScriptExecutor(ScriptExecutorType executorType) {
        switch (executorType) {
            case NASHORN:
                return new NasHornJava8Executor();
        }
        return null;
    }

    public Executable take() throws InterruptedException {
        return executors.take();
    }

    public void put(Executable executor) throws InterruptedException {
        executors.put(executor);
    }

    public void clear() {
        //TODO : clear the executors
        executors.clear();
    }

}