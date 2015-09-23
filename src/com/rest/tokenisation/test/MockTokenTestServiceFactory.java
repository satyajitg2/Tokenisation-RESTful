package com.rest.tokenisation.test;

import org.glassfish.hk2.api.Factory;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MockTokenTestServiceFactory implements Factory<MockTokenTestService> {

	@Override
	public void dispose(MockTokenTestService arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MockTokenTestService provide() {
		final MockTokenTestService mockedService = Mockito.mock(MockTokenTestService.class);
		Mockito.when(mockedService.initialiseTokenService(Mockito.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) 
                                              throws Throwable {
                String name = (String)invocation.getArguments()[0];
                return "Hello " + name;
            }

        });
		return mockedService;		
	}
	
}
