/*
 * Copyright 2016 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.datamapper.engine.core;

import org.apache.avro.generic.GenericRecord;
import org.wso2.datamapper.engine.core.exceptions.JSException;

/**
 * This interface should be implemented by script executors of Data Mapper Engine
 */
public interface IScriptExecutor {

    /**
     * This method executes the mapping config in the {@link MappingResourceLoader} on input generic record and returns the output generic record
     *
     * @param resourceModel
     * @param inputRecord
     * @return
     * @throws JSException
     */
    GenericRecord executeMapping(MappingResourceLoader resourceModel, GenericRecord inputRecord) throws JSException;
}
