/**
 * Copyright 2018 Dynatrace LLC
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
 */

package com.dynatrace.openkit.test.dynatrace.remote;

import com.dynatrace.openkit.test.AbstractDynatraceTest;
import com.dynatrace.openkit.test.OpenKitTestFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import java.util.Random;

@Ignore("Integration tests are ignored")
public class AbstractRemoteDynatraceTest extends AbstractDynatraceTest {

    @Before
    public void setUp() throws InterruptedException {
        openKitTestImpl = OpenKitTestFactory.createDynatraceRemoteInstance(TEST_APPLICATION_NAME, TEST_APPLICATION_ID, new Random(System
            .currentTimeMillis()).nextLong(), TEST_ENDPOINT);
        openKit = openKitTestImpl;
    }

    @Before
    public void printStart() {
        System.out.println("Remote Dynatrace Test: " + this.getClass().getSimpleName() + " - Start");
    }

    @After
    public void printEnd() {
        System.out.println("Remote Dynatrace Test: " + this.getClass().getSimpleName() + " - End");
        openKit.shutdown();
    }
}