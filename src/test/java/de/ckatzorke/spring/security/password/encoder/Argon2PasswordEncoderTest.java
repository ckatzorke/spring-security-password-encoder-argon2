/*
 * Copyright (C) Christian Katzorke <ckatzorke@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.ckatzorke.spring.security.password.encoder;

import org.junit.Test;

/**
 * @author Christian Katzorke ckatzorke@gmail.com
 *
 */
public class Argon2PasswordEncoderTest {

	Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
	
	
	@Test
	public void encodePwd() throws Exception {
		String encoded = encoder.encode("passw0rd");
		System.out.println(encoded);
		encoded = encoder.encode("passw0rd");
		System.out.println(encoded);
	}
}
