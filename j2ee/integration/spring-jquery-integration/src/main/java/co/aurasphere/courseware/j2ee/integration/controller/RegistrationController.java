/*
 * MIT License
 *
 * Copyright (c) 2018 Donato Rimenti
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.courseware.j2ee.integration.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.aurasphere.courseware.j2ee.integration.model.RegistrationResponse;

/**
 * Rest controller for handling new users' registration process.
 * 
 * @author Donato Rimenti
 *
 */
@RestController
@RequestMapping("/register")
public class RegistrationController {

	/**
	 * List of names unavailable for registration.
	 */
	private List<String> unavailableNames = Arrays.asList("Mark", "Vincent", "John", "Frank", "Robert");

	/**
	 * Tests if a name is available for registration by checking it against a
	 * list of unavailable names.
	 * 
	 * @param username
	 *            the name whose availability will be checked
	 * @return true if the username is available, false otherwise
	 */
	@GetMapping("/checkNameAvailable")
	public RegistrationResponse checkNameAvailable(@RequestParam("username") String username) {
		boolean nameAvailable = !unavailableNames.contains(username);
		return new RegistrationResponse(nameAvailable);
	}

}
