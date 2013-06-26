package br.com.utfpr.core.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.utfpr.parser.easymock.MockPrefixParserTest;


@RunWith(Suite.class)
@SuiteClasses({ PostfixParserTest.class, MockPrefixParserTest.class })
public class AllParsers {

}
