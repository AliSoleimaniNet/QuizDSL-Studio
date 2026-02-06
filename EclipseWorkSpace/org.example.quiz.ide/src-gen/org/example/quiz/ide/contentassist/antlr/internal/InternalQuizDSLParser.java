package org.example.quiz.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.example.quiz.services.QuizDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQuizDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'admin'", "'student'", "'public'", "'private'", "'theme'", "'primary'", "'secondary'", "'bg'", "'text'", "'font'", "'end'", "'user'", "'uid'", "'pwd'", "'name'", "'platform'", "'title'", "'subtitle'", "'logo'", "'use_theme'", "'quiz'", "'label'", "'desc'", "'icon'", "'time'", "'min'", "'start'", "'score'", "'single_choice'", "'options'", "'correct'", "'val'", "'media'", "'multi_choice'", "'true_false'", "'answer'", "'descriptive'", "'->'", "'result'", "'responses'", "'{'", "'}'", "'question'", "'provided_answer'", "'is_correct'", "'shuffle'", "'show_result'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalQuizDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQuizDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQuizDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQuizDSL.g"; }


    	private QuizDSLGrammarAccess grammarAccess;

    	public void setGrammarAccess(QuizDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleQuizGameSystem"
    // InternalQuizDSL.g:53:1: entryRuleQuizGameSystem : ruleQuizGameSystem EOF ;
    public final void entryRuleQuizGameSystem() throws RecognitionException {
        try {
            // InternalQuizDSL.g:54:1: ( ruleQuizGameSystem EOF )
            // InternalQuizDSL.g:55:1: ruleQuizGameSystem EOF
            {
             before(grammarAccess.getQuizGameSystemRule()); 
            pushFollow(FOLLOW_1);
            ruleQuizGameSystem();

            state._fsp--;

             after(grammarAccess.getQuizGameSystemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuizGameSystem"


    // $ANTLR start "ruleQuizGameSystem"
    // InternalQuizDSL.g:62:1: ruleQuizGameSystem : ( ( rule__QuizGameSystem__Alternatives )* ) ;
    public final void ruleQuizGameSystem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:66:2: ( ( ( rule__QuizGameSystem__Alternatives )* ) )
            // InternalQuizDSL.g:67:2: ( ( rule__QuizGameSystem__Alternatives )* )
            {
            // InternalQuizDSL.g:67:2: ( ( rule__QuizGameSystem__Alternatives )* )
            // InternalQuizDSL.g:68:3: ( rule__QuizGameSystem__Alternatives )*
            {
             before(grammarAccess.getQuizGameSystemAccess().getAlternatives()); 
            // InternalQuizDSL.g:69:3: ( rule__QuizGameSystem__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||LA1_0==24||LA1_0==28||LA1_0==51) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQuizDSL.g:69:4: rule__QuizGameSystem__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__QuizGameSystem__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getQuizGameSystemAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuizGameSystem"


    // $ANTLR start "entryRuleTheme"
    // InternalQuizDSL.g:78:1: entryRuleTheme : ruleTheme EOF ;
    public final void entryRuleTheme() throws RecognitionException {
        try {
            // InternalQuizDSL.g:79:1: ( ruleTheme EOF )
            // InternalQuizDSL.g:80:1: ruleTheme EOF
            {
             before(grammarAccess.getThemeRule()); 
            pushFollow(FOLLOW_1);
            ruleTheme();

            state._fsp--;

             after(grammarAccess.getThemeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTheme"


    // $ANTLR start "ruleTheme"
    // InternalQuizDSL.g:87:1: ruleTheme : ( ( rule__Theme__Group__0 ) ) ;
    public final void ruleTheme() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:91:2: ( ( ( rule__Theme__Group__0 ) ) )
            // InternalQuizDSL.g:92:2: ( ( rule__Theme__Group__0 ) )
            {
            // InternalQuizDSL.g:92:2: ( ( rule__Theme__Group__0 ) )
            // InternalQuizDSL.g:93:3: ( rule__Theme__Group__0 )
            {
             before(grammarAccess.getThemeAccess().getGroup()); 
            // InternalQuizDSL.g:94:3: ( rule__Theme__Group__0 )
            // InternalQuizDSL.g:94:4: rule__Theme__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Theme__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTheme"


    // $ANTLR start "entryRuleUser"
    // InternalQuizDSL.g:103:1: entryRuleUser : ruleUser EOF ;
    public final void entryRuleUser() throws RecognitionException {
        try {
            // InternalQuizDSL.g:104:1: ( ruleUser EOF )
            // InternalQuizDSL.g:105:1: ruleUser EOF
            {
             before(grammarAccess.getUserRule()); 
            pushFollow(FOLLOW_1);
            ruleUser();

            state._fsp--;

             after(grammarAccess.getUserRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUser"


    // $ANTLR start "ruleUser"
    // InternalQuizDSL.g:112:1: ruleUser : ( ( rule__User__Group__0 ) ) ;
    public final void ruleUser() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:116:2: ( ( ( rule__User__Group__0 ) ) )
            // InternalQuizDSL.g:117:2: ( ( rule__User__Group__0 ) )
            {
            // InternalQuizDSL.g:117:2: ( ( rule__User__Group__0 ) )
            // InternalQuizDSL.g:118:3: ( rule__User__Group__0 )
            {
             before(grammarAccess.getUserAccess().getGroup()); 
            // InternalQuizDSL.g:119:3: ( rule__User__Group__0 )
            // InternalQuizDSL.g:119:4: rule__User__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__User__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUser"


    // $ANTLR start "entryRuleQuizPlatform"
    // InternalQuizDSL.g:128:1: entryRuleQuizPlatform : ruleQuizPlatform EOF ;
    public final void entryRuleQuizPlatform() throws RecognitionException {
        try {
            // InternalQuizDSL.g:129:1: ( ruleQuizPlatform EOF )
            // InternalQuizDSL.g:130:1: ruleQuizPlatform EOF
            {
             before(grammarAccess.getQuizPlatformRule()); 
            pushFollow(FOLLOW_1);
            ruleQuizPlatform();

            state._fsp--;

             after(grammarAccess.getQuizPlatformRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuizPlatform"


    // $ANTLR start "ruleQuizPlatform"
    // InternalQuizDSL.g:137:1: ruleQuizPlatform : ( ( rule__QuizPlatform__Group__0 ) ) ;
    public final void ruleQuizPlatform() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:141:2: ( ( ( rule__QuizPlatform__Group__0 ) ) )
            // InternalQuizDSL.g:142:2: ( ( rule__QuizPlatform__Group__0 ) )
            {
            // InternalQuizDSL.g:142:2: ( ( rule__QuizPlatform__Group__0 ) )
            // InternalQuizDSL.g:143:3: ( rule__QuizPlatform__Group__0 )
            {
             before(grammarAccess.getQuizPlatformAccess().getGroup()); 
            // InternalQuizDSL.g:144:3: ( rule__QuizPlatform__Group__0 )
            // InternalQuizDSL.g:144:4: rule__QuizPlatform__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuizPlatform"


    // $ANTLR start "entryRuleQuiz"
    // InternalQuizDSL.g:153:1: entryRuleQuiz : ruleQuiz EOF ;
    public final void entryRuleQuiz() throws RecognitionException {
        try {
            // InternalQuizDSL.g:154:1: ( ruleQuiz EOF )
            // InternalQuizDSL.g:155:1: ruleQuiz EOF
            {
             before(grammarAccess.getQuizRule()); 
            pushFollow(FOLLOW_1);
            ruleQuiz();

            state._fsp--;

             after(grammarAccess.getQuizRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuiz"


    // $ANTLR start "ruleQuiz"
    // InternalQuizDSL.g:162:1: ruleQuiz : ( ( rule__Quiz__Group__0 ) ) ;
    public final void ruleQuiz() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:166:2: ( ( ( rule__Quiz__Group__0 ) ) )
            // InternalQuizDSL.g:167:2: ( ( rule__Quiz__Group__0 ) )
            {
            // InternalQuizDSL.g:167:2: ( ( rule__Quiz__Group__0 ) )
            // InternalQuizDSL.g:168:3: ( rule__Quiz__Group__0 )
            {
             before(grammarAccess.getQuizAccess().getGroup()); 
            // InternalQuizDSL.g:169:3: ( rule__Quiz__Group__0 )
            // InternalQuizDSL.g:169:4: rule__Quiz__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuiz"


    // $ANTLR start "entryRuleQuizConfig"
    // InternalQuizDSL.g:178:1: entryRuleQuizConfig : ruleQuizConfig EOF ;
    public final void entryRuleQuizConfig() throws RecognitionException {
        try {
            // InternalQuizDSL.g:179:1: ( ruleQuizConfig EOF )
            // InternalQuizDSL.g:180:1: ruleQuizConfig EOF
            {
             before(grammarAccess.getQuizConfigRule()); 
            pushFollow(FOLLOW_1);
            ruleQuizConfig();

            state._fsp--;

             after(grammarAccess.getQuizConfigRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuizConfig"


    // $ANTLR start "ruleQuizConfig"
    // InternalQuizDSL.g:187:1: ruleQuizConfig : ( ( rule__QuizConfig__Group__0 ) ) ;
    public final void ruleQuizConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:191:2: ( ( ( rule__QuizConfig__Group__0 ) ) )
            // InternalQuizDSL.g:192:2: ( ( rule__QuizConfig__Group__0 ) )
            {
            // InternalQuizDSL.g:192:2: ( ( rule__QuizConfig__Group__0 ) )
            // InternalQuizDSL.g:193:3: ( rule__QuizConfig__Group__0 )
            {
             before(grammarAccess.getQuizConfigAccess().getGroup()); 
            // InternalQuizDSL.g:194:3: ( rule__QuizConfig__Group__0 )
            // InternalQuizDSL.g:194:4: rule__QuizConfig__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuizConfig"


    // $ANTLR start "entryRuleQuestion"
    // InternalQuizDSL.g:203:1: entryRuleQuestion : ruleQuestion EOF ;
    public final void entryRuleQuestion() throws RecognitionException {
        try {
            // InternalQuizDSL.g:204:1: ( ruleQuestion EOF )
            // InternalQuizDSL.g:205:1: ruleQuestion EOF
            {
             before(grammarAccess.getQuestionRule()); 
            pushFollow(FOLLOW_1);
            ruleQuestion();

            state._fsp--;

             after(grammarAccess.getQuestionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuestion"


    // $ANTLR start "ruleQuestion"
    // InternalQuizDSL.g:212:1: ruleQuestion : ( ( rule__Question__Alternatives ) ) ;
    public final void ruleQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:216:2: ( ( ( rule__Question__Alternatives ) ) )
            // InternalQuizDSL.g:217:2: ( ( rule__Question__Alternatives ) )
            {
            // InternalQuizDSL.g:217:2: ( ( rule__Question__Alternatives ) )
            // InternalQuizDSL.g:218:3: ( rule__Question__Alternatives )
            {
             before(grammarAccess.getQuestionAccess().getAlternatives()); 
            // InternalQuizDSL.g:219:3: ( rule__Question__Alternatives )
            // InternalQuizDSL.g:219:4: rule__Question__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Question__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQuestionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuestion"


    // $ANTLR start "entryRuleSingleChoiceQuestion"
    // InternalQuizDSL.g:228:1: entryRuleSingleChoiceQuestion : ruleSingleChoiceQuestion EOF ;
    public final void entryRuleSingleChoiceQuestion() throws RecognitionException {
        try {
            // InternalQuizDSL.g:229:1: ( ruleSingleChoiceQuestion EOF )
            // InternalQuizDSL.g:230:1: ruleSingleChoiceQuestion EOF
            {
             before(grammarAccess.getSingleChoiceQuestionRule()); 
            pushFollow(FOLLOW_1);
            ruleSingleChoiceQuestion();

            state._fsp--;

             after(grammarAccess.getSingleChoiceQuestionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSingleChoiceQuestion"


    // $ANTLR start "ruleSingleChoiceQuestion"
    // InternalQuizDSL.g:237:1: ruleSingleChoiceQuestion : ( ( rule__SingleChoiceQuestion__Group__0 ) ) ;
    public final void ruleSingleChoiceQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:241:2: ( ( ( rule__SingleChoiceQuestion__Group__0 ) ) )
            // InternalQuizDSL.g:242:2: ( ( rule__SingleChoiceQuestion__Group__0 ) )
            {
            // InternalQuizDSL.g:242:2: ( ( rule__SingleChoiceQuestion__Group__0 ) )
            // InternalQuizDSL.g:243:3: ( rule__SingleChoiceQuestion__Group__0 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getGroup()); 
            // InternalQuizDSL.g:244:3: ( rule__SingleChoiceQuestion__Group__0 )
            // InternalQuizDSL.g:244:4: rule__SingleChoiceQuestion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSingleChoiceQuestion"


    // $ANTLR start "entryRuleMultipleChoiceQuestion"
    // InternalQuizDSL.g:253:1: entryRuleMultipleChoiceQuestion : ruleMultipleChoiceQuestion EOF ;
    public final void entryRuleMultipleChoiceQuestion() throws RecognitionException {
        try {
            // InternalQuizDSL.g:254:1: ( ruleMultipleChoiceQuestion EOF )
            // InternalQuizDSL.g:255:1: ruleMultipleChoiceQuestion EOF
            {
             before(grammarAccess.getMultipleChoiceQuestionRule()); 
            pushFollow(FOLLOW_1);
            ruleMultipleChoiceQuestion();

            state._fsp--;

             after(grammarAccess.getMultipleChoiceQuestionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultipleChoiceQuestion"


    // $ANTLR start "ruleMultipleChoiceQuestion"
    // InternalQuizDSL.g:262:1: ruleMultipleChoiceQuestion : ( ( rule__MultipleChoiceQuestion__Group__0 ) ) ;
    public final void ruleMultipleChoiceQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:266:2: ( ( ( rule__MultipleChoiceQuestion__Group__0 ) ) )
            // InternalQuizDSL.g:267:2: ( ( rule__MultipleChoiceQuestion__Group__0 ) )
            {
            // InternalQuizDSL.g:267:2: ( ( rule__MultipleChoiceQuestion__Group__0 ) )
            // InternalQuizDSL.g:268:3: ( rule__MultipleChoiceQuestion__Group__0 )
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getGroup()); 
            // InternalQuizDSL.g:269:3: ( rule__MultipleChoiceQuestion__Group__0 )
            // InternalQuizDSL.g:269:4: rule__MultipleChoiceQuestion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultipleChoiceQuestion"


    // $ANTLR start "entryRuleTrueFalseQuestion"
    // InternalQuizDSL.g:278:1: entryRuleTrueFalseQuestion : ruleTrueFalseQuestion EOF ;
    public final void entryRuleTrueFalseQuestion() throws RecognitionException {
        try {
            // InternalQuizDSL.g:279:1: ( ruleTrueFalseQuestion EOF )
            // InternalQuizDSL.g:280:1: ruleTrueFalseQuestion EOF
            {
             before(grammarAccess.getTrueFalseQuestionRule()); 
            pushFollow(FOLLOW_1);
            ruleTrueFalseQuestion();

            state._fsp--;

             after(grammarAccess.getTrueFalseQuestionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrueFalseQuestion"


    // $ANTLR start "ruleTrueFalseQuestion"
    // InternalQuizDSL.g:287:1: ruleTrueFalseQuestion : ( ( rule__TrueFalseQuestion__Group__0 ) ) ;
    public final void ruleTrueFalseQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:291:2: ( ( ( rule__TrueFalseQuestion__Group__0 ) ) )
            // InternalQuizDSL.g:292:2: ( ( rule__TrueFalseQuestion__Group__0 ) )
            {
            // InternalQuizDSL.g:292:2: ( ( rule__TrueFalseQuestion__Group__0 ) )
            // InternalQuizDSL.g:293:3: ( rule__TrueFalseQuestion__Group__0 )
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getGroup()); 
            // InternalQuizDSL.g:294:3: ( rule__TrueFalseQuestion__Group__0 )
            // InternalQuizDSL.g:294:4: rule__TrueFalseQuestion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrueFalseQuestionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrueFalseQuestion"


    // $ANTLR start "entryRuleDescriptiveQuestion"
    // InternalQuizDSL.g:303:1: entryRuleDescriptiveQuestion : ruleDescriptiveQuestion EOF ;
    public final void entryRuleDescriptiveQuestion() throws RecognitionException {
        try {
            // InternalQuizDSL.g:304:1: ( ruleDescriptiveQuestion EOF )
            // InternalQuizDSL.g:305:1: ruleDescriptiveQuestion EOF
            {
             before(grammarAccess.getDescriptiveQuestionRule()); 
            pushFollow(FOLLOW_1);
            ruleDescriptiveQuestion();

            state._fsp--;

             after(grammarAccess.getDescriptiveQuestionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDescriptiveQuestion"


    // $ANTLR start "ruleDescriptiveQuestion"
    // InternalQuizDSL.g:312:1: ruleDescriptiveQuestion : ( ( rule__DescriptiveQuestion__Group__0 ) ) ;
    public final void ruleDescriptiveQuestion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:316:2: ( ( ( rule__DescriptiveQuestion__Group__0 ) ) )
            // InternalQuizDSL.g:317:2: ( ( rule__DescriptiveQuestion__Group__0 ) )
            {
            // InternalQuizDSL.g:317:2: ( ( rule__DescriptiveQuestion__Group__0 ) )
            // InternalQuizDSL.g:318:3: ( rule__DescriptiveQuestion__Group__0 )
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getGroup()); 
            // InternalQuizDSL.g:319:3: ( rule__DescriptiveQuestion__Group__0 )
            // InternalQuizDSL.g:319:4: rule__DescriptiveQuestion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDescriptiveQuestionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDescriptiveQuestion"


    // $ANTLR start "entryRuleOption"
    // InternalQuizDSL.g:328:1: entryRuleOption : ruleOption EOF ;
    public final void entryRuleOption() throws RecognitionException {
        try {
            // InternalQuizDSL.g:329:1: ( ruleOption EOF )
            // InternalQuizDSL.g:330:1: ruleOption EOF
            {
             before(grammarAccess.getOptionRule()); 
            pushFollow(FOLLOW_1);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getOptionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalQuizDSL.g:337:1: ruleOption : ( ( rule__Option__Group__0 ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:341:2: ( ( ( rule__Option__Group__0 ) ) )
            // InternalQuizDSL.g:342:2: ( ( rule__Option__Group__0 ) )
            {
            // InternalQuizDSL.g:342:2: ( ( rule__Option__Group__0 ) )
            // InternalQuizDSL.g:343:3: ( rule__Option__Group__0 )
            {
             before(grammarAccess.getOptionAccess().getGroup()); 
            // InternalQuizDSL.g:344:3: ( rule__Option__Group__0 )
            // InternalQuizDSL.g:344:4: rule__Option__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Option__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRuleEBoolean"
    // InternalQuizDSL.g:353:1: entryRuleEBoolean : ruleEBoolean EOF ;
    public final void entryRuleEBoolean() throws RecognitionException {
        try {
            // InternalQuizDSL.g:354:1: ( ruleEBoolean EOF )
            // InternalQuizDSL.g:355:1: ruleEBoolean EOF
            {
             before(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getEBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalQuizDSL.g:362:1: ruleEBoolean : ( ( rule__EBoolean__Alternatives ) ) ;
    public final void ruleEBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:366:2: ( ( ( rule__EBoolean__Alternatives ) ) )
            // InternalQuizDSL.g:367:2: ( ( rule__EBoolean__Alternatives ) )
            {
            // InternalQuizDSL.g:367:2: ( ( rule__EBoolean__Alternatives ) )
            // InternalQuizDSL.g:368:3: ( rule__EBoolean__Alternatives )
            {
             before(grammarAccess.getEBooleanAccess().getAlternatives()); 
            // InternalQuizDSL.g:369:3: ( rule__EBoolean__Alternatives )
            // InternalQuizDSL.g:369:4: rule__EBoolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EBoolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleQuizResult"
    // InternalQuizDSL.g:378:1: entryRuleQuizResult : ruleQuizResult EOF ;
    public final void entryRuleQuizResult() throws RecognitionException {
        try {
            // InternalQuizDSL.g:379:1: ( ruleQuizResult EOF )
            // InternalQuizDSL.g:380:1: ruleQuizResult EOF
            {
             before(grammarAccess.getQuizResultRule()); 
            pushFollow(FOLLOW_1);
            ruleQuizResult();

            state._fsp--;

             after(grammarAccess.getQuizResultRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuizResult"


    // $ANTLR start "ruleQuizResult"
    // InternalQuizDSL.g:387:1: ruleQuizResult : ( ( rule__QuizResult__Group__0 ) ) ;
    public final void ruleQuizResult() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:391:2: ( ( ( rule__QuizResult__Group__0 ) ) )
            // InternalQuizDSL.g:392:2: ( ( rule__QuizResult__Group__0 ) )
            {
            // InternalQuizDSL.g:392:2: ( ( rule__QuizResult__Group__0 ) )
            // InternalQuizDSL.g:393:3: ( rule__QuizResult__Group__0 )
            {
             before(grammarAccess.getQuizResultAccess().getGroup()); 
            // InternalQuizDSL.g:394:3: ( rule__QuizResult__Group__0 )
            // InternalQuizDSL.g:394:4: rule__QuizResult__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuizResult"


    // $ANTLR start "entryRuleUserResponse"
    // InternalQuizDSL.g:403:1: entryRuleUserResponse : ruleUserResponse EOF ;
    public final void entryRuleUserResponse() throws RecognitionException {
        try {
            // InternalQuizDSL.g:404:1: ( ruleUserResponse EOF )
            // InternalQuizDSL.g:405:1: ruleUserResponse EOF
            {
             before(grammarAccess.getUserResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleUserResponse();

            state._fsp--;

             after(grammarAccess.getUserResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUserResponse"


    // $ANTLR start "ruleUserResponse"
    // InternalQuizDSL.g:412:1: ruleUserResponse : ( ( rule__UserResponse__Group__0 ) ) ;
    public final void ruleUserResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:416:2: ( ( ( rule__UserResponse__Group__0 ) ) )
            // InternalQuizDSL.g:417:2: ( ( rule__UserResponse__Group__0 ) )
            {
            // InternalQuizDSL.g:417:2: ( ( rule__UserResponse__Group__0 ) )
            // InternalQuizDSL.g:418:3: ( rule__UserResponse__Group__0 )
            {
             before(grammarAccess.getUserResponseAccess().getGroup()); 
            // InternalQuizDSL.g:419:3: ( rule__UserResponse__Group__0 )
            // InternalQuizDSL.g:419:4: rule__UserResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserResponse"


    // $ANTLR start "ruleUserRole"
    // InternalQuizDSL.g:428:1: ruleUserRole : ( ( rule__UserRole__Alternatives ) ) ;
    public final void ruleUserRole() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:432:1: ( ( ( rule__UserRole__Alternatives ) ) )
            // InternalQuizDSL.g:433:2: ( ( rule__UserRole__Alternatives ) )
            {
            // InternalQuizDSL.g:433:2: ( ( rule__UserRole__Alternatives ) )
            // InternalQuizDSL.g:434:3: ( rule__UserRole__Alternatives )
            {
             before(grammarAccess.getUserRoleAccess().getAlternatives()); 
            // InternalQuizDSL.g:435:3: ( rule__UserRole__Alternatives )
            // InternalQuizDSL.g:435:4: rule__UserRole__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UserRole__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUserRoleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserRole"


    // $ANTLR start "ruleAccessType"
    // InternalQuizDSL.g:444:1: ruleAccessType : ( ( rule__AccessType__Alternatives ) ) ;
    public final void ruleAccessType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:448:1: ( ( ( rule__AccessType__Alternatives ) ) )
            // InternalQuizDSL.g:449:2: ( ( rule__AccessType__Alternatives ) )
            {
            // InternalQuizDSL.g:449:2: ( ( rule__AccessType__Alternatives ) )
            // InternalQuizDSL.g:450:3: ( rule__AccessType__Alternatives )
            {
             before(grammarAccess.getAccessTypeAccess().getAlternatives()); 
            // InternalQuizDSL.g:451:3: ( rule__AccessType__Alternatives )
            // InternalQuizDSL.g:451:4: rule__AccessType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AccessType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAccessTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAccessType"


    // $ANTLR start "rule__QuizGameSystem__Alternatives"
    // InternalQuizDSL.g:459:1: rule__QuizGameSystem__Alternatives : ( ( ( rule__QuizGameSystem__ThemesAssignment_0 ) ) | ( ( rule__QuizGameSystem__UsersAssignment_1 ) ) | ( ( rule__QuizGameSystem__PlatformAssignment_2 ) ) | ( ( rule__QuizGameSystem__ResultsAssignment_3 ) ) );
    public final void rule__QuizGameSystem__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:463:1: ( ( ( rule__QuizGameSystem__ThemesAssignment_0 ) ) | ( ( rule__QuizGameSystem__UsersAssignment_1 ) ) | ( ( rule__QuizGameSystem__PlatformAssignment_2 ) ) | ( ( rule__QuizGameSystem__ResultsAssignment_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 24:
                {
                alt2=2;
                }
                break;
            case 28:
                {
                alt2=3;
                }
                break;
            case 51:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalQuizDSL.g:464:2: ( ( rule__QuizGameSystem__ThemesAssignment_0 ) )
                    {
                    // InternalQuizDSL.g:464:2: ( ( rule__QuizGameSystem__ThemesAssignment_0 ) )
                    // InternalQuizDSL.g:465:3: ( rule__QuizGameSystem__ThemesAssignment_0 )
                    {
                     before(grammarAccess.getQuizGameSystemAccess().getThemesAssignment_0()); 
                    // InternalQuizDSL.g:466:3: ( rule__QuizGameSystem__ThemesAssignment_0 )
                    // InternalQuizDSL.g:466:4: rule__QuizGameSystem__ThemesAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizGameSystem__ThemesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuizGameSystemAccess().getThemesAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:470:2: ( ( rule__QuizGameSystem__UsersAssignment_1 ) )
                    {
                    // InternalQuizDSL.g:470:2: ( ( rule__QuizGameSystem__UsersAssignment_1 ) )
                    // InternalQuizDSL.g:471:3: ( rule__QuizGameSystem__UsersAssignment_1 )
                    {
                     before(grammarAccess.getQuizGameSystemAccess().getUsersAssignment_1()); 
                    // InternalQuizDSL.g:472:3: ( rule__QuizGameSystem__UsersAssignment_1 )
                    // InternalQuizDSL.g:472:4: rule__QuizGameSystem__UsersAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizGameSystem__UsersAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuizGameSystemAccess().getUsersAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQuizDSL.g:476:2: ( ( rule__QuizGameSystem__PlatformAssignment_2 ) )
                    {
                    // InternalQuizDSL.g:476:2: ( ( rule__QuizGameSystem__PlatformAssignment_2 ) )
                    // InternalQuizDSL.g:477:3: ( rule__QuizGameSystem__PlatformAssignment_2 )
                    {
                     before(grammarAccess.getQuizGameSystemAccess().getPlatformAssignment_2()); 
                    // InternalQuizDSL.g:478:3: ( rule__QuizGameSystem__PlatformAssignment_2 )
                    // InternalQuizDSL.g:478:4: rule__QuizGameSystem__PlatformAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizGameSystem__PlatformAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuizGameSystemAccess().getPlatformAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQuizDSL.g:482:2: ( ( rule__QuizGameSystem__ResultsAssignment_3 ) )
                    {
                    // InternalQuizDSL.g:482:2: ( ( rule__QuizGameSystem__ResultsAssignment_3 ) )
                    // InternalQuizDSL.g:483:3: ( rule__QuizGameSystem__ResultsAssignment_3 )
                    {
                     before(grammarAccess.getQuizGameSystemAccess().getResultsAssignment_3()); 
                    // InternalQuizDSL.g:484:3: ( rule__QuizGameSystem__ResultsAssignment_3 )
                    // InternalQuizDSL.g:484:4: rule__QuizGameSystem__ResultsAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizGameSystem__ResultsAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuizGameSystemAccess().getResultsAssignment_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizGameSystem__Alternatives"


    // $ANTLR start "rule__Question__Alternatives"
    // InternalQuizDSL.g:492:1: rule__Question__Alternatives : ( ( ruleSingleChoiceQuestion ) | ( ruleMultipleChoiceQuestion ) | ( ruleTrueFalseQuestion ) | ( ruleDescriptiveQuestion ) );
    public final void rule__Question__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:496:1: ( ( ruleSingleChoiceQuestion ) | ( ruleMultipleChoiceQuestion ) | ( ruleTrueFalseQuestion ) | ( ruleDescriptiveQuestion ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt3=1;
                }
                break;
            case 46:
                {
                alt3=2;
                }
                break;
            case 47:
                {
                alt3=3;
                }
                break;
            case 49:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalQuizDSL.g:497:2: ( ruleSingleChoiceQuestion )
                    {
                    // InternalQuizDSL.g:497:2: ( ruleSingleChoiceQuestion )
                    // InternalQuizDSL.g:498:3: ruleSingleChoiceQuestion
                    {
                     before(grammarAccess.getQuestionAccess().getSingleChoiceQuestionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSingleChoiceQuestion();

                    state._fsp--;

                     after(grammarAccess.getQuestionAccess().getSingleChoiceQuestionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:503:2: ( ruleMultipleChoiceQuestion )
                    {
                    // InternalQuizDSL.g:503:2: ( ruleMultipleChoiceQuestion )
                    // InternalQuizDSL.g:504:3: ruleMultipleChoiceQuestion
                    {
                     before(grammarAccess.getQuestionAccess().getMultipleChoiceQuestionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMultipleChoiceQuestion();

                    state._fsp--;

                     after(grammarAccess.getQuestionAccess().getMultipleChoiceQuestionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalQuizDSL.g:509:2: ( ruleTrueFalseQuestion )
                    {
                    // InternalQuizDSL.g:509:2: ( ruleTrueFalseQuestion )
                    // InternalQuizDSL.g:510:3: ruleTrueFalseQuestion
                    {
                     before(grammarAccess.getQuestionAccess().getTrueFalseQuestionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleTrueFalseQuestion();

                    state._fsp--;

                     after(grammarAccess.getQuestionAccess().getTrueFalseQuestionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalQuizDSL.g:515:2: ( ruleDescriptiveQuestion )
                    {
                    // InternalQuizDSL.g:515:2: ( ruleDescriptiveQuestion )
                    // InternalQuizDSL.g:516:3: ruleDescriptiveQuestion
                    {
                     before(grammarAccess.getQuestionAccess().getDescriptiveQuestionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleDescriptiveQuestion();

                    state._fsp--;

                     after(grammarAccess.getQuestionAccess().getDescriptiveQuestionParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Question__Alternatives"


    // $ANTLR start "rule__EBoolean__Alternatives"
    // InternalQuizDSL.g:525:1: rule__EBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:529:1: ( ( 'true' ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalQuizDSL.g:530:2: ( 'true' )
                    {
                    // InternalQuizDSL.g:530:2: ( 'true' )
                    // InternalQuizDSL.g:531:3: 'true'
                    {
                     before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:536:2: ( 'false' )
                    {
                    // InternalQuizDSL.g:536:2: ( 'false' )
                    // InternalQuizDSL.g:537:3: 'false'
                    {
                     before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EBoolean__Alternatives"


    // $ANTLR start "rule__UserRole__Alternatives"
    // InternalQuizDSL.g:546:1: rule__UserRole__Alternatives : ( ( ( 'admin' ) ) | ( ( 'student' ) ) );
    public final void rule__UserRole__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:550:1: ( ( ( 'admin' ) ) | ( ( 'student' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalQuizDSL.g:551:2: ( ( 'admin' ) )
                    {
                    // InternalQuizDSL.g:551:2: ( ( 'admin' ) )
                    // InternalQuizDSL.g:552:3: ( 'admin' )
                    {
                     before(grammarAccess.getUserRoleAccess().getADMINEnumLiteralDeclaration_0()); 
                    // InternalQuizDSL.g:553:3: ( 'admin' )
                    // InternalQuizDSL.g:553:4: 'admin'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getUserRoleAccess().getADMINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:557:2: ( ( 'student' ) )
                    {
                    // InternalQuizDSL.g:557:2: ( ( 'student' ) )
                    // InternalQuizDSL.g:558:3: ( 'student' )
                    {
                     before(grammarAccess.getUserRoleAccess().getSTUDENTEnumLiteralDeclaration_1()); 
                    // InternalQuizDSL.g:559:3: ( 'student' )
                    // InternalQuizDSL.g:559:4: 'student'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getUserRoleAccess().getSTUDENTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserRole__Alternatives"


    // $ANTLR start "rule__AccessType__Alternatives"
    // InternalQuizDSL.g:567:1: rule__AccessType__Alternatives : ( ( ( 'public' ) ) | ( ( 'private' ) ) );
    public final void rule__AccessType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:571:1: ( ( ( 'public' ) ) | ( ( 'private' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalQuizDSL.g:572:2: ( ( 'public' ) )
                    {
                    // InternalQuizDSL.g:572:2: ( ( 'public' ) )
                    // InternalQuizDSL.g:573:3: ( 'public' )
                    {
                     before(grammarAccess.getAccessTypeAccess().getPUBLICEnumLiteralDeclaration_0()); 
                    // InternalQuizDSL.g:574:3: ( 'public' )
                    // InternalQuizDSL.g:574:4: 'public'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getAccessTypeAccess().getPUBLICEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:578:2: ( ( 'private' ) )
                    {
                    // InternalQuizDSL.g:578:2: ( ( 'private' ) )
                    // InternalQuizDSL.g:579:3: ( 'private' )
                    {
                     before(grammarAccess.getAccessTypeAccess().getPRIVATEEnumLiteralDeclaration_1()); 
                    // InternalQuizDSL.g:580:3: ( 'private' )
                    // InternalQuizDSL.g:580:4: 'private'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getAccessTypeAccess().getPRIVATEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AccessType__Alternatives"


    // $ANTLR start "rule__Theme__Group__0"
    // InternalQuizDSL.g:588:1: rule__Theme__Group__0 : rule__Theme__Group__0__Impl rule__Theme__Group__1 ;
    public final void rule__Theme__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:592:1: ( rule__Theme__Group__0__Impl rule__Theme__Group__1 )
            // InternalQuizDSL.g:593:2: rule__Theme__Group__0__Impl rule__Theme__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Theme__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__0"


    // $ANTLR start "rule__Theme__Group__0__Impl"
    // InternalQuizDSL.g:600:1: rule__Theme__Group__0__Impl : ( 'theme' ) ;
    public final void rule__Theme__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:604:1: ( ( 'theme' ) )
            // InternalQuizDSL.g:605:1: ( 'theme' )
            {
            // InternalQuizDSL.g:605:1: ( 'theme' )
            // InternalQuizDSL.g:606:2: 'theme'
            {
             before(grammarAccess.getThemeAccess().getThemeKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getThemeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__0__Impl"


    // $ANTLR start "rule__Theme__Group__1"
    // InternalQuizDSL.g:615:1: rule__Theme__Group__1 : rule__Theme__Group__1__Impl rule__Theme__Group__2 ;
    public final void rule__Theme__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:619:1: ( rule__Theme__Group__1__Impl rule__Theme__Group__2 )
            // InternalQuizDSL.g:620:2: rule__Theme__Group__1__Impl rule__Theme__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Theme__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__1"


    // $ANTLR start "rule__Theme__Group__1__Impl"
    // InternalQuizDSL.g:627:1: rule__Theme__Group__1__Impl : ( ( rule__Theme__NameAssignment_1 ) ) ;
    public final void rule__Theme__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:631:1: ( ( ( rule__Theme__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:632:1: ( ( rule__Theme__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:632:1: ( ( rule__Theme__NameAssignment_1 ) )
            // InternalQuizDSL.g:633:2: ( rule__Theme__NameAssignment_1 )
            {
             before(grammarAccess.getThemeAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:634:2: ( rule__Theme__NameAssignment_1 )
            // InternalQuizDSL.g:634:3: rule__Theme__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Theme__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__1__Impl"


    // $ANTLR start "rule__Theme__Group__2"
    // InternalQuizDSL.g:642:1: rule__Theme__Group__2 : rule__Theme__Group__2__Impl rule__Theme__Group__3 ;
    public final void rule__Theme__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:646:1: ( rule__Theme__Group__2__Impl rule__Theme__Group__3 )
            // InternalQuizDSL.g:647:2: rule__Theme__Group__2__Impl rule__Theme__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Theme__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__2"


    // $ANTLR start "rule__Theme__Group__2__Impl"
    // InternalQuizDSL.g:654:1: rule__Theme__Group__2__Impl : ( 'primary' ) ;
    public final void rule__Theme__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:658:1: ( ( 'primary' ) )
            // InternalQuizDSL.g:659:1: ( 'primary' )
            {
            // InternalQuizDSL.g:659:1: ( 'primary' )
            // InternalQuizDSL.g:660:2: 'primary'
            {
             before(grammarAccess.getThemeAccess().getPrimaryKeyword_2()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getPrimaryKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__2__Impl"


    // $ANTLR start "rule__Theme__Group__3"
    // InternalQuizDSL.g:669:1: rule__Theme__Group__3 : rule__Theme__Group__3__Impl rule__Theme__Group__4 ;
    public final void rule__Theme__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:673:1: ( rule__Theme__Group__3__Impl rule__Theme__Group__4 )
            // InternalQuizDSL.g:674:2: rule__Theme__Group__3__Impl rule__Theme__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Theme__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__3"


    // $ANTLR start "rule__Theme__Group__3__Impl"
    // InternalQuizDSL.g:681:1: rule__Theme__Group__3__Impl : ( ( rule__Theme__PrimaryColorAssignment_3 ) ) ;
    public final void rule__Theme__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:685:1: ( ( ( rule__Theme__PrimaryColorAssignment_3 ) ) )
            // InternalQuizDSL.g:686:1: ( ( rule__Theme__PrimaryColorAssignment_3 ) )
            {
            // InternalQuizDSL.g:686:1: ( ( rule__Theme__PrimaryColorAssignment_3 ) )
            // InternalQuizDSL.g:687:2: ( rule__Theme__PrimaryColorAssignment_3 )
            {
             before(grammarAccess.getThemeAccess().getPrimaryColorAssignment_3()); 
            // InternalQuizDSL.g:688:2: ( rule__Theme__PrimaryColorAssignment_3 )
            // InternalQuizDSL.g:688:3: rule__Theme__PrimaryColorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Theme__PrimaryColorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getPrimaryColorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__3__Impl"


    // $ANTLR start "rule__Theme__Group__4"
    // InternalQuizDSL.g:696:1: rule__Theme__Group__4 : rule__Theme__Group__4__Impl rule__Theme__Group__5 ;
    public final void rule__Theme__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:700:1: ( rule__Theme__Group__4__Impl rule__Theme__Group__5 )
            // InternalQuizDSL.g:701:2: rule__Theme__Group__4__Impl rule__Theme__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__Theme__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__4"


    // $ANTLR start "rule__Theme__Group__4__Impl"
    // InternalQuizDSL.g:708:1: rule__Theme__Group__4__Impl : ( 'secondary' ) ;
    public final void rule__Theme__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:712:1: ( ( 'secondary' ) )
            // InternalQuizDSL.g:713:1: ( 'secondary' )
            {
            // InternalQuizDSL.g:713:1: ( 'secondary' )
            // InternalQuizDSL.g:714:2: 'secondary'
            {
             before(grammarAccess.getThemeAccess().getSecondaryKeyword_4()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getSecondaryKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__4__Impl"


    // $ANTLR start "rule__Theme__Group__5"
    // InternalQuizDSL.g:723:1: rule__Theme__Group__5 : rule__Theme__Group__5__Impl rule__Theme__Group__6 ;
    public final void rule__Theme__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:727:1: ( rule__Theme__Group__5__Impl rule__Theme__Group__6 )
            // InternalQuizDSL.g:728:2: rule__Theme__Group__5__Impl rule__Theme__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Theme__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__5"


    // $ANTLR start "rule__Theme__Group__5__Impl"
    // InternalQuizDSL.g:735:1: rule__Theme__Group__5__Impl : ( ( rule__Theme__SecondaryColorAssignment_5 ) ) ;
    public final void rule__Theme__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:739:1: ( ( ( rule__Theme__SecondaryColorAssignment_5 ) ) )
            // InternalQuizDSL.g:740:1: ( ( rule__Theme__SecondaryColorAssignment_5 ) )
            {
            // InternalQuizDSL.g:740:1: ( ( rule__Theme__SecondaryColorAssignment_5 ) )
            // InternalQuizDSL.g:741:2: ( rule__Theme__SecondaryColorAssignment_5 )
            {
             before(grammarAccess.getThemeAccess().getSecondaryColorAssignment_5()); 
            // InternalQuizDSL.g:742:2: ( rule__Theme__SecondaryColorAssignment_5 )
            // InternalQuizDSL.g:742:3: rule__Theme__SecondaryColorAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Theme__SecondaryColorAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getSecondaryColorAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__5__Impl"


    // $ANTLR start "rule__Theme__Group__6"
    // InternalQuizDSL.g:750:1: rule__Theme__Group__6 : rule__Theme__Group__6__Impl rule__Theme__Group__7 ;
    public final void rule__Theme__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:754:1: ( rule__Theme__Group__6__Impl rule__Theme__Group__7 )
            // InternalQuizDSL.g:755:2: rule__Theme__Group__6__Impl rule__Theme__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Theme__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__6"


    // $ANTLR start "rule__Theme__Group__6__Impl"
    // InternalQuizDSL.g:762:1: rule__Theme__Group__6__Impl : ( 'bg' ) ;
    public final void rule__Theme__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:766:1: ( ( 'bg' ) )
            // InternalQuizDSL.g:767:1: ( 'bg' )
            {
            // InternalQuizDSL.g:767:1: ( 'bg' )
            // InternalQuizDSL.g:768:2: 'bg'
            {
             before(grammarAccess.getThemeAccess().getBgKeyword_6()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getBgKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__6__Impl"


    // $ANTLR start "rule__Theme__Group__7"
    // InternalQuizDSL.g:777:1: rule__Theme__Group__7 : rule__Theme__Group__7__Impl rule__Theme__Group__8 ;
    public final void rule__Theme__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:781:1: ( rule__Theme__Group__7__Impl rule__Theme__Group__8 )
            // InternalQuizDSL.g:782:2: rule__Theme__Group__7__Impl rule__Theme__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Theme__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__7"


    // $ANTLR start "rule__Theme__Group__7__Impl"
    // InternalQuizDSL.g:789:1: rule__Theme__Group__7__Impl : ( ( rule__Theme__BackgroundColorAssignment_7 ) ) ;
    public final void rule__Theme__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:793:1: ( ( ( rule__Theme__BackgroundColorAssignment_7 ) ) )
            // InternalQuizDSL.g:794:1: ( ( rule__Theme__BackgroundColorAssignment_7 ) )
            {
            // InternalQuizDSL.g:794:1: ( ( rule__Theme__BackgroundColorAssignment_7 ) )
            // InternalQuizDSL.g:795:2: ( rule__Theme__BackgroundColorAssignment_7 )
            {
             before(grammarAccess.getThemeAccess().getBackgroundColorAssignment_7()); 
            // InternalQuizDSL.g:796:2: ( rule__Theme__BackgroundColorAssignment_7 )
            // InternalQuizDSL.g:796:3: rule__Theme__BackgroundColorAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Theme__BackgroundColorAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getBackgroundColorAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__7__Impl"


    // $ANTLR start "rule__Theme__Group__8"
    // InternalQuizDSL.g:804:1: rule__Theme__Group__8 : rule__Theme__Group__8__Impl rule__Theme__Group__9 ;
    public final void rule__Theme__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:808:1: ( rule__Theme__Group__8__Impl rule__Theme__Group__9 )
            // InternalQuizDSL.g:809:2: rule__Theme__Group__8__Impl rule__Theme__Group__9
            {
            pushFollow(FOLLOW_6);
            rule__Theme__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__8"


    // $ANTLR start "rule__Theme__Group__8__Impl"
    // InternalQuizDSL.g:816:1: rule__Theme__Group__8__Impl : ( 'text' ) ;
    public final void rule__Theme__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:820:1: ( ( 'text' ) )
            // InternalQuizDSL.g:821:1: ( 'text' )
            {
            // InternalQuizDSL.g:821:1: ( 'text' )
            // InternalQuizDSL.g:822:2: 'text'
            {
             before(grammarAccess.getThemeAccess().getTextKeyword_8()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getTextKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__8__Impl"


    // $ANTLR start "rule__Theme__Group__9"
    // InternalQuizDSL.g:831:1: rule__Theme__Group__9 : rule__Theme__Group__9__Impl rule__Theme__Group__10 ;
    public final void rule__Theme__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:835:1: ( rule__Theme__Group__9__Impl rule__Theme__Group__10 )
            // InternalQuizDSL.g:836:2: rule__Theme__Group__9__Impl rule__Theme__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__Theme__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__9"


    // $ANTLR start "rule__Theme__Group__9__Impl"
    // InternalQuizDSL.g:843:1: rule__Theme__Group__9__Impl : ( ( rule__Theme__TextColorAssignment_9 ) ) ;
    public final void rule__Theme__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:847:1: ( ( ( rule__Theme__TextColorAssignment_9 ) ) )
            // InternalQuizDSL.g:848:1: ( ( rule__Theme__TextColorAssignment_9 ) )
            {
            // InternalQuizDSL.g:848:1: ( ( rule__Theme__TextColorAssignment_9 ) )
            // InternalQuizDSL.g:849:2: ( rule__Theme__TextColorAssignment_9 )
            {
             before(grammarAccess.getThemeAccess().getTextColorAssignment_9()); 
            // InternalQuizDSL.g:850:2: ( rule__Theme__TextColorAssignment_9 )
            // InternalQuizDSL.g:850:3: rule__Theme__TextColorAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Theme__TextColorAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getTextColorAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__9__Impl"


    // $ANTLR start "rule__Theme__Group__10"
    // InternalQuizDSL.g:858:1: rule__Theme__Group__10 : rule__Theme__Group__10__Impl rule__Theme__Group__11 ;
    public final void rule__Theme__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:862:1: ( rule__Theme__Group__10__Impl rule__Theme__Group__11 )
            // InternalQuizDSL.g:863:2: rule__Theme__Group__10__Impl rule__Theme__Group__11
            {
            pushFollow(FOLLOW_6);
            rule__Theme__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__10"


    // $ANTLR start "rule__Theme__Group__10__Impl"
    // InternalQuizDSL.g:870:1: rule__Theme__Group__10__Impl : ( 'font' ) ;
    public final void rule__Theme__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:874:1: ( ( 'font' ) )
            // InternalQuizDSL.g:875:1: ( 'font' )
            {
            // InternalQuizDSL.g:875:1: ( 'font' )
            // InternalQuizDSL.g:876:2: 'font'
            {
             before(grammarAccess.getThemeAccess().getFontKeyword_10()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getFontKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__10__Impl"


    // $ANTLR start "rule__Theme__Group__11"
    // InternalQuizDSL.g:885:1: rule__Theme__Group__11 : rule__Theme__Group__11__Impl rule__Theme__Group__12 ;
    public final void rule__Theme__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:889:1: ( rule__Theme__Group__11__Impl rule__Theme__Group__12 )
            // InternalQuizDSL.g:890:2: rule__Theme__Group__11__Impl rule__Theme__Group__12
            {
            pushFollow(FOLLOW_11);
            rule__Theme__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Theme__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__11"


    // $ANTLR start "rule__Theme__Group__11__Impl"
    // InternalQuizDSL.g:897:1: rule__Theme__Group__11__Impl : ( ( rule__Theme__FontNameAssignment_11 ) ) ;
    public final void rule__Theme__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:901:1: ( ( ( rule__Theme__FontNameAssignment_11 ) ) )
            // InternalQuizDSL.g:902:1: ( ( rule__Theme__FontNameAssignment_11 ) )
            {
            // InternalQuizDSL.g:902:1: ( ( rule__Theme__FontNameAssignment_11 ) )
            // InternalQuizDSL.g:903:2: ( rule__Theme__FontNameAssignment_11 )
            {
             before(grammarAccess.getThemeAccess().getFontNameAssignment_11()); 
            // InternalQuizDSL.g:904:2: ( rule__Theme__FontNameAssignment_11 )
            // InternalQuizDSL.g:904:3: rule__Theme__FontNameAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Theme__FontNameAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getThemeAccess().getFontNameAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__11__Impl"


    // $ANTLR start "rule__Theme__Group__12"
    // InternalQuizDSL.g:912:1: rule__Theme__Group__12 : rule__Theme__Group__12__Impl ;
    public final void rule__Theme__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:916:1: ( rule__Theme__Group__12__Impl )
            // InternalQuizDSL.g:917:2: rule__Theme__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Theme__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__12"


    // $ANTLR start "rule__Theme__Group__12__Impl"
    // InternalQuizDSL.g:923:1: rule__Theme__Group__12__Impl : ( 'end' ) ;
    public final void rule__Theme__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:927:1: ( ( 'end' ) )
            // InternalQuizDSL.g:928:1: ( 'end' )
            {
            // InternalQuizDSL.g:928:1: ( 'end' )
            // InternalQuizDSL.g:929:2: 'end'
            {
             before(grammarAccess.getThemeAccess().getEndKeyword_12()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getEndKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__Group__12__Impl"


    // $ANTLR start "rule__User__Group__0"
    // InternalQuizDSL.g:939:1: rule__User__Group__0 : rule__User__Group__0__Impl rule__User__Group__1 ;
    public final void rule__User__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:943:1: ( rule__User__Group__0__Impl rule__User__Group__1 )
            // InternalQuizDSL.g:944:2: rule__User__Group__0__Impl rule__User__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__User__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0"


    // $ANTLR start "rule__User__Group__0__Impl"
    // InternalQuizDSL.g:951:1: rule__User__Group__0__Impl : ( 'user' ) ;
    public final void rule__User__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:955:1: ( ( 'user' ) )
            // InternalQuizDSL.g:956:1: ( 'user' )
            {
            // InternalQuizDSL.g:956:1: ( 'user' )
            // InternalQuizDSL.g:957:2: 'user'
            {
             before(grammarAccess.getUserAccess().getUserKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getUserKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0__Impl"


    // $ANTLR start "rule__User__Group__1"
    // InternalQuizDSL.g:966:1: rule__User__Group__1 : rule__User__Group__1__Impl rule__User__Group__2 ;
    public final void rule__User__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:970:1: ( rule__User__Group__1__Impl rule__User__Group__2 )
            // InternalQuizDSL.g:971:2: rule__User__Group__1__Impl rule__User__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__User__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1"


    // $ANTLR start "rule__User__Group__1__Impl"
    // InternalQuizDSL.g:978:1: rule__User__Group__1__Impl : ( ( rule__User__NameAssignment_1 ) ) ;
    public final void rule__User__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:982:1: ( ( ( rule__User__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:983:1: ( ( rule__User__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:983:1: ( ( rule__User__NameAssignment_1 ) )
            // InternalQuizDSL.g:984:2: ( rule__User__NameAssignment_1 )
            {
             before(grammarAccess.getUserAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:985:2: ( rule__User__NameAssignment_1 )
            // InternalQuizDSL.g:985:3: rule__User__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__User__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1__Impl"


    // $ANTLR start "rule__User__Group__2"
    // InternalQuizDSL.g:993:1: rule__User__Group__2 : rule__User__Group__2__Impl rule__User__Group__3 ;
    public final void rule__User__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:997:1: ( rule__User__Group__2__Impl rule__User__Group__3 )
            // InternalQuizDSL.g:998:2: rule__User__Group__2__Impl rule__User__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__User__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__2"


    // $ANTLR start "rule__User__Group__2__Impl"
    // InternalQuizDSL.g:1005:1: rule__User__Group__2__Impl : ( 'uid' ) ;
    public final void rule__User__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1009:1: ( ( 'uid' ) )
            // InternalQuizDSL.g:1010:1: ( 'uid' )
            {
            // InternalQuizDSL.g:1010:1: ( 'uid' )
            // InternalQuizDSL.g:1011:2: 'uid'
            {
             before(grammarAccess.getUserAccess().getUidKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getUidKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__2__Impl"


    // $ANTLR start "rule__User__Group__3"
    // InternalQuizDSL.g:1020:1: rule__User__Group__3 : rule__User__Group__3__Impl rule__User__Group__4 ;
    public final void rule__User__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1024:1: ( rule__User__Group__3__Impl rule__User__Group__4 )
            // InternalQuizDSL.g:1025:2: rule__User__Group__3__Impl rule__User__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__User__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__3"


    // $ANTLR start "rule__User__Group__3__Impl"
    // InternalQuizDSL.g:1032:1: rule__User__Group__3__Impl : ( ( rule__User__UsernameAssignment_3 ) ) ;
    public final void rule__User__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1036:1: ( ( ( rule__User__UsernameAssignment_3 ) ) )
            // InternalQuizDSL.g:1037:1: ( ( rule__User__UsernameAssignment_3 ) )
            {
            // InternalQuizDSL.g:1037:1: ( ( rule__User__UsernameAssignment_3 ) )
            // InternalQuizDSL.g:1038:2: ( rule__User__UsernameAssignment_3 )
            {
             before(grammarAccess.getUserAccess().getUsernameAssignment_3()); 
            // InternalQuizDSL.g:1039:2: ( rule__User__UsernameAssignment_3 )
            // InternalQuizDSL.g:1039:3: rule__User__UsernameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__User__UsernameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getUsernameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__3__Impl"


    // $ANTLR start "rule__User__Group__4"
    // InternalQuizDSL.g:1047:1: rule__User__Group__4 : rule__User__Group__4__Impl rule__User__Group__5 ;
    public final void rule__User__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1051:1: ( rule__User__Group__4__Impl rule__User__Group__5 )
            // InternalQuizDSL.g:1052:2: rule__User__Group__4__Impl rule__User__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__User__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__4"


    // $ANTLR start "rule__User__Group__4__Impl"
    // InternalQuizDSL.g:1059:1: rule__User__Group__4__Impl : ( 'pwd' ) ;
    public final void rule__User__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1063:1: ( ( 'pwd' ) )
            // InternalQuizDSL.g:1064:1: ( 'pwd' )
            {
            // InternalQuizDSL.g:1064:1: ( 'pwd' )
            // InternalQuizDSL.g:1065:2: 'pwd'
            {
             before(grammarAccess.getUserAccess().getPwdKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getPwdKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__4__Impl"


    // $ANTLR start "rule__User__Group__5"
    // InternalQuizDSL.g:1074:1: rule__User__Group__5 : rule__User__Group__5__Impl rule__User__Group__6 ;
    public final void rule__User__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1078:1: ( rule__User__Group__5__Impl rule__User__Group__6 )
            // InternalQuizDSL.g:1079:2: rule__User__Group__5__Impl rule__User__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__User__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__5"


    // $ANTLR start "rule__User__Group__5__Impl"
    // InternalQuizDSL.g:1086:1: rule__User__Group__5__Impl : ( ( rule__User__PasswordAssignment_5 ) ) ;
    public final void rule__User__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1090:1: ( ( ( rule__User__PasswordAssignment_5 ) ) )
            // InternalQuizDSL.g:1091:1: ( ( rule__User__PasswordAssignment_5 ) )
            {
            // InternalQuizDSL.g:1091:1: ( ( rule__User__PasswordAssignment_5 ) )
            // InternalQuizDSL.g:1092:2: ( rule__User__PasswordAssignment_5 )
            {
             before(grammarAccess.getUserAccess().getPasswordAssignment_5()); 
            // InternalQuizDSL.g:1093:2: ( rule__User__PasswordAssignment_5 )
            // InternalQuizDSL.g:1093:3: rule__User__PasswordAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__User__PasswordAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getPasswordAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__5__Impl"


    // $ANTLR start "rule__User__Group__6"
    // InternalQuizDSL.g:1101:1: rule__User__Group__6 : rule__User__Group__6__Impl rule__User__Group__7 ;
    public final void rule__User__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1105:1: ( rule__User__Group__6__Impl rule__User__Group__7 )
            // InternalQuizDSL.g:1106:2: rule__User__Group__6__Impl rule__User__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__User__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__6"


    // $ANTLR start "rule__User__Group__6__Impl"
    // InternalQuizDSL.g:1113:1: rule__User__Group__6__Impl : ( 'name' ) ;
    public final void rule__User__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1117:1: ( ( 'name' ) )
            // InternalQuizDSL.g:1118:1: ( 'name' )
            {
            // InternalQuizDSL.g:1118:1: ( 'name' )
            // InternalQuizDSL.g:1119:2: 'name'
            {
             before(grammarAccess.getUserAccess().getNameKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getNameKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__6__Impl"


    // $ANTLR start "rule__User__Group__7"
    // InternalQuizDSL.g:1128:1: rule__User__Group__7 : rule__User__Group__7__Impl rule__User__Group__8 ;
    public final void rule__User__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1132:1: ( rule__User__Group__7__Impl rule__User__Group__8 )
            // InternalQuizDSL.g:1133:2: rule__User__Group__7__Impl rule__User__Group__8
            {
            pushFollow(FOLLOW_15);
            rule__User__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__7"


    // $ANTLR start "rule__User__Group__7__Impl"
    // InternalQuizDSL.g:1140:1: rule__User__Group__7__Impl : ( ( rule__User__FullNameAssignment_7 ) ) ;
    public final void rule__User__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1144:1: ( ( ( rule__User__FullNameAssignment_7 ) ) )
            // InternalQuizDSL.g:1145:1: ( ( rule__User__FullNameAssignment_7 ) )
            {
            // InternalQuizDSL.g:1145:1: ( ( rule__User__FullNameAssignment_7 ) )
            // InternalQuizDSL.g:1146:2: ( rule__User__FullNameAssignment_7 )
            {
             before(grammarAccess.getUserAccess().getFullNameAssignment_7()); 
            // InternalQuizDSL.g:1147:2: ( rule__User__FullNameAssignment_7 )
            // InternalQuizDSL.g:1147:3: rule__User__FullNameAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__User__FullNameAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getFullNameAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__7__Impl"


    // $ANTLR start "rule__User__Group__8"
    // InternalQuizDSL.g:1155:1: rule__User__Group__8 : rule__User__Group__8__Impl rule__User__Group__9 ;
    public final void rule__User__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1159:1: ( rule__User__Group__8__Impl rule__User__Group__9 )
            // InternalQuizDSL.g:1160:2: rule__User__Group__8__Impl rule__User__Group__9
            {
            pushFollow(FOLLOW_15);
            rule__User__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__User__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__8"


    // $ANTLR start "rule__User__Group__8__Impl"
    // InternalQuizDSL.g:1167:1: rule__User__Group__8__Impl : ( ( rule__User__RoleAssignment_8 )? ) ;
    public final void rule__User__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1171:1: ( ( ( rule__User__RoleAssignment_8 )? ) )
            // InternalQuizDSL.g:1172:1: ( ( rule__User__RoleAssignment_8 )? )
            {
            // InternalQuizDSL.g:1172:1: ( ( rule__User__RoleAssignment_8 )? )
            // InternalQuizDSL.g:1173:2: ( rule__User__RoleAssignment_8 )?
            {
             before(grammarAccess.getUserAccess().getRoleAssignment_8()); 
            // InternalQuizDSL.g:1174:2: ( rule__User__RoleAssignment_8 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=13 && LA7_0<=14)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalQuizDSL.g:1174:3: rule__User__RoleAssignment_8
                    {
                    pushFollow(FOLLOW_2);
                    rule__User__RoleAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUserAccess().getRoleAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__8__Impl"


    // $ANTLR start "rule__User__Group__9"
    // InternalQuizDSL.g:1182:1: rule__User__Group__9 : rule__User__Group__9__Impl ;
    public final void rule__User__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1186:1: ( rule__User__Group__9__Impl )
            // InternalQuizDSL.g:1187:2: rule__User__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__User__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__9"


    // $ANTLR start "rule__User__Group__9__Impl"
    // InternalQuizDSL.g:1193:1: rule__User__Group__9__Impl : ( 'end' ) ;
    public final void rule__User__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1197:1: ( ( 'end' ) )
            // InternalQuizDSL.g:1198:1: ( 'end' )
            {
            // InternalQuizDSL.g:1198:1: ( 'end' )
            // InternalQuizDSL.g:1199:2: 'end'
            {
             before(grammarAccess.getUserAccess().getEndKeyword_9()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getEndKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__9__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__0"
    // InternalQuizDSL.g:1209:1: rule__QuizPlatform__Group__0 : rule__QuizPlatform__Group__0__Impl rule__QuizPlatform__Group__1 ;
    public final void rule__QuizPlatform__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1213:1: ( rule__QuizPlatform__Group__0__Impl rule__QuizPlatform__Group__1 )
            // InternalQuizDSL.g:1214:2: rule__QuizPlatform__Group__0__Impl rule__QuizPlatform__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__QuizPlatform__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__0"


    // $ANTLR start "rule__QuizPlatform__Group__0__Impl"
    // InternalQuizDSL.g:1221:1: rule__QuizPlatform__Group__0__Impl : ( 'platform' ) ;
    public final void rule__QuizPlatform__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1225:1: ( ( 'platform' ) )
            // InternalQuizDSL.g:1226:1: ( 'platform' )
            {
            // InternalQuizDSL.g:1226:1: ( 'platform' )
            // InternalQuizDSL.g:1227:2: 'platform'
            {
             before(grammarAccess.getQuizPlatformAccess().getPlatformKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getPlatformKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__0__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__1"
    // InternalQuizDSL.g:1236:1: rule__QuizPlatform__Group__1 : rule__QuizPlatform__Group__1__Impl rule__QuizPlatform__Group__2 ;
    public final void rule__QuizPlatform__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1240:1: ( rule__QuizPlatform__Group__1__Impl rule__QuizPlatform__Group__2 )
            // InternalQuizDSL.g:1241:2: rule__QuizPlatform__Group__1__Impl rule__QuizPlatform__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__QuizPlatform__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__1"


    // $ANTLR start "rule__QuizPlatform__Group__1__Impl"
    // InternalQuizDSL.g:1248:1: rule__QuizPlatform__Group__1__Impl : ( ( rule__QuizPlatform__NameAssignment_1 ) ) ;
    public final void rule__QuizPlatform__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1252:1: ( ( ( rule__QuizPlatform__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:1253:1: ( ( rule__QuizPlatform__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:1253:1: ( ( rule__QuizPlatform__NameAssignment_1 ) )
            // InternalQuizDSL.g:1254:2: ( rule__QuizPlatform__NameAssignment_1 )
            {
             before(grammarAccess.getQuizPlatformAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:1255:2: ( rule__QuizPlatform__NameAssignment_1 )
            // InternalQuizDSL.g:1255:3: rule__QuizPlatform__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__1__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__2"
    // InternalQuizDSL.g:1263:1: rule__QuizPlatform__Group__2 : rule__QuizPlatform__Group__2__Impl rule__QuizPlatform__Group__3 ;
    public final void rule__QuizPlatform__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1267:1: ( rule__QuizPlatform__Group__2__Impl rule__QuizPlatform__Group__3 )
            // InternalQuizDSL.g:1268:2: rule__QuizPlatform__Group__2__Impl rule__QuizPlatform__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__QuizPlatform__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__2"


    // $ANTLR start "rule__QuizPlatform__Group__2__Impl"
    // InternalQuizDSL.g:1275:1: rule__QuizPlatform__Group__2__Impl : ( 'title' ) ;
    public final void rule__QuizPlatform__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1279:1: ( ( 'title' ) )
            // InternalQuizDSL.g:1280:1: ( 'title' )
            {
            // InternalQuizDSL.g:1280:1: ( 'title' )
            // InternalQuizDSL.g:1281:2: 'title'
            {
             before(grammarAccess.getQuizPlatformAccess().getTitleKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getTitleKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__2__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__3"
    // InternalQuizDSL.g:1290:1: rule__QuizPlatform__Group__3 : rule__QuizPlatform__Group__3__Impl rule__QuizPlatform__Group__4 ;
    public final void rule__QuizPlatform__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1294:1: ( rule__QuizPlatform__Group__3__Impl rule__QuizPlatform__Group__4 )
            // InternalQuizDSL.g:1295:2: rule__QuizPlatform__Group__3__Impl rule__QuizPlatform__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__QuizPlatform__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__3"


    // $ANTLR start "rule__QuizPlatform__Group__3__Impl"
    // InternalQuizDSL.g:1302:1: rule__QuizPlatform__Group__3__Impl : ( ( rule__QuizPlatform__TitleAssignment_3 ) ) ;
    public final void rule__QuizPlatform__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1306:1: ( ( ( rule__QuizPlatform__TitleAssignment_3 ) ) )
            // InternalQuizDSL.g:1307:1: ( ( rule__QuizPlatform__TitleAssignment_3 ) )
            {
            // InternalQuizDSL.g:1307:1: ( ( rule__QuizPlatform__TitleAssignment_3 ) )
            // InternalQuizDSL.g:1308:2: ( rule__QuizPlatform__TitleAssignment_3 )
            {
             before(grammarAccess.getQuizPlatformAccess().getTitleAssignment_3()); 
            // InternalQuizDSL.g:1309:2: ( rule__QuizPlatform__TitleAssignment_3 )
            // InternalQuizDSL.g:1309:3: rule__QuizPlatform__TitleAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__TitleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getTitleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__3__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__4"
    // InternalQuizDSL.g:1317:1: rule__QuizPlatform__Group__4 : rule__QuizPlatform__Group__4__Impl rule__QuizPlatform__Group__5 ;
    public final void rule__QuizPlatform__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1321:1: ( rule__QuizPlatform__Group__4__Impl rule__QuizPlatform__Group__5 )
            // InternalQuizDSL.g:1322:2: rule__QuizPlatform__Group__4__Impl rule__QuizPlatform__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__QuizPlatform__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__4"


    // $ANTLR start "rule__QuizPlatform__Group__4__Impl"
    // InternalQuizDSL.g:1329:1: rule__QuizPlatform__Group__4__Impl : ( 'subtitle' ) ;
    public final void rule__QuizPlatform__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1333:1: ( ( 'subtitle' ) )
            // InternalQuizDSL.g:1334:1: ( 'subtitle' )
            {
            // InternalQuizDSL.g:1334:1: ( 'subtitle' )
            // InternalQuizDSL.g:1335:2: 'subtitle'
            {
             before(grammarAccess.getQuizPlatformAccess().getSubtitleKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getSubtitleKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__4__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__5"
    // InternalQuizDSL.g:1344:1: rule__QuizPlatform__Group__5 : rule__QuizPlatform__Group__5__Impl rule__QuizPlatform__Group__6 ;
    public final void rule__QuizPlatform__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1348:1: ( rule__QuizPlatform__Group__5__Impl rule__QuizPlatform__Group__6 )
            // InternalQuizDSL.g:1349:2: rule__QuizPlatform__Group__5__Impl rule__QuizPlatform__Group__6
            {
            pushFollow(FOLLOW_18);
            rule__QuizPlatform__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__5"


    // $ANTLR start "rule__QuizPlatform__Group__5__Impl"
    // InternalQuizDSL.g:1356:1: rule__QuizPlatform__Group__5__Impl : ( ( rule__QuizPlatform__SubtitleAssignment_5 ) ) ;
    public final void rule__QuizPlatform__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1360:1: ( ( ( rule__QuizPlatform__SubtitleAssignment_5 ) ) )
            // InternalQuizDSL.g:1361:1: ( ( rule__QuizPlatform__SubtitleAssignment_5 ) )
            {
            // InternalQuizDSL.g:1361:1: ( ( rule__QuizPlatform__SubtitleAssignment_5 ) )
            // InternalQuizDSL.g:1362:2: ( rule__QuizPlatform__SubtitleAssignment_5 )
            {
             before(grammarAccess.getQuizPlatformAccess().getSubtitleAssignment_5()); 
            // InternalQuizDSL.g:1363:2: ( rule__QuizPlatform__SubtitleAssignment_5 )
            // InternalQuizDSL.g:1363:3: rule__QuizPlatform__SubtitleAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__SubtitleAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getSubtitleAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__5__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__6"
    // InternalQuizDSL.g:1371:1: rule__QuizPlatform__Group__6 : rule__QuizPlatform__Group__6__Impl rule__QuizPlatform__Group__7 ;
    public final void rule__QuizPlatform__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1375:1: ( rule__QuizPlatform__Group__6__Impl rule__QuizPlatform__Group__7 )
            // InternalQuizDSL.g:1376:2: rule__QuizPlatform__Group__6__Impl rule__QuizPlatform__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__QuizPlatform__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__6"


    // $ANTLR start "rule__QuizPlatform__Group__6__Impl"
    // InternalQuizDSL.g:1383:1: rule__QuizPlatform__Group__6__Impl : ( 'logo' ) ;
    public final void rule__QuizPlatform__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1387:1: ( ( 'logo' ) )
            // InternalQuizDSL.g:1388:1: ( 'logo' )
            {
            // InternalQuizDSL.g:1388:1: ( 'logo' )
            // InternalQuizDSL.g:1389:2: 'logo'
            {
             before(grammarAccess.getQuizPlatformAccess().getLogoKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getLogoKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__6__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__7"
    // InternalQuizDSL.g:1398:1: rule__QuizPlatform__Group__7 : rule__QuizPlatform__Group__7__Impl rule__QuizPlatform__Group__8 ;
    public final void rule__QuizPlatform__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1402:1: ( rule__QuizPlatform__Group__7__Impl rule__QuizPlatform__Group__8 )
            // InternalQuizDSL.g:1403:2: rule__QuizPlatform__Group__7__Impl rule__QuizPlatform__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__QuizPlatform__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__7"


    // $ANTLR start "rule__QuizPlatform__Group__7__Impl"
    // InternalQuizDSL.g:1410:1: rule__QuizPlatform__Group__7__Impl : ( ( rule__QuizPlatform__LogoAssignment_7 ) ) ;
    public final void rule__QuizPlatform__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1414:1: ( ( ( rule__QuizPlatform__LogoAssignment_7 ) ) )
            // InternalQuizDSL.g:1415:1: ( ( rule__QuizPlatform__LogoAssignment_7 ) )
            {
            // InternalQuizDSL.g:1415:1: ( ( rule__QuizPlatform__LogoAssignment_7 ) )
            // InternalQuizDSL.g:1416:2: ( rule__QuizPlatform__LogoAssignment_7 )
            {
             before(grammarAccess.getQuizPlatformAccess().getLogoAssignment_7()); 
            // InternalQuizDSL.g:1417:2: ( rule__QuizPlatform__LogoAssignment_7 )
            // InternalQuizDSL.g:1417:3: rule__QuizPlatform__LogoAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__LogoAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getLogoAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__7__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__8"
    // InternalQuizDSL.g:1425:1: rule__QuizPlatform__Group__8 : rule__QuizPlatform__Group__8__Impl rule__QuizPlatform__Group__9 ;
    public final void rule__QuizPlatform__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1429:1: ( rule__QuizPlatform__Group__8__Impl rule__QuizPlatform__Group__9 )
            // InternalQuizDSL.g:1430:2: rule__QuizPlatform__Group__8__Impl rule__QuizPlatform__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__QuizPlatform__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__8"


    // $ANTLR start "rule__QuizPlatform__Group__8__Impl"
    // InternalQuizDSL.g:1437:1: rule__QuizPlatform__Group__8__Impl : ( 'use_theme' ) ;
    public final void rule__QuizPlatform__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1441:1: ( ( 'use_theme' ) )
            // InternalQuizDSL.g:1442:1: ( 'use_theme' )
            {
            // InternalQuizDSL.g:1442:1: ( 'use_theme' )
            // InternalQuizDSL.g:1443:2: 'use_theme'
            {
             before(grammarAccess.getQuizPlatformAccess().getUse_themeKeyword_8()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getUse_themeKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__8__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__9"
    // InternalQuizDSL.g:1452:1: rule__QuizPlatform__Group__9 : rule__QuizPlatform__Group__9__Impl rule__QuizPlatform__Group__10 ;
    public final void rule__QuizPlatform__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1456:1: ( rule__QuizPlatform__Group__9__Impl rule__QuizPlatform__Group__10 )
            // InternalQuizDSL.g:1457:2: rule__QuizPlatform__Group__9__Impl rule__QuizPlatform__Group__10
            {
            pushFollow(FOLLOW_20);
            rule__QuizPlatform__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__9"


    // $ANTLR start "rule__QuizPlatform__Group__9__Impl"
    // InternalQuizDSL.g:1464:1: rule__QuizPlatform__Group__9__Impl : ( ( rule__QuizPlatform__ThemeAssignment_9 ) ) ;
    public final void rule__QuizPlatform__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1468:1: ( ( ( rule__QuizPlatform__ThemeAssignment_9 ) ) )
            // InternalQuizDSL.g:1469:1: ( ( rule__QuizPlatform__ThemeAssignment_9 ) )
            {
            // InternalQuizDSL.g:1469:1: ( ( rule__QuizPlatform__ThemeAssignment_9 ) )
            // InternalQuizDSL.g:1470:2: ( rule__QuizPlatform__ThemeAssignment_9 )
            {
             before(grammarAccess.getQuizPlatformAccess().getThemeAssignment_9()); 
            // InternalQuizDSL.g:1471:2: ( rule__QuizPlatform__ThemeAssignment_9 )
            // InternalQuizDSL.g:1471:3: rule__QuizPlatform__ThemeAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__ThemeAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getQuizPlatformAccess().getThemeAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__9__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__10"
    // InternalQuizDSL.g:1479:1: rule__QuizPlatform__Group__10 : rule__QuizPlatform__Group__10__Impl rule__QuizPlatform__Group__11 ;
    public final void rule__QuizPlatform__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1483:1: ( rule__QuizPlatform__Group__10__Impl rule__QuizPlatform__Group__11 )
            // InternalQuizDSL.g:1484:2: rule__QuizPlatform__Group__10__Impl rule__QuizPlatform__Group__11
            {
            pushFollow(FOLLOW_20);
            rule__QuizPlatform__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__10"


    // $ANTLR start "rule__QuizPlatform__Group__10__Impl"
    // InternalQuizDSL.g:1491:1: rule__QuizPlatform__Group__10__Impl : ( ( rule__QuizPlatform__QuizzesAssignment_10 )* ) ;
    public final void rule__QuizPlatform__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1495:1: ( ( ( rule__QuizPlatform__QuizzesAssignment_10 )* ) )
            // InternalQuizDSL.g:1496:1: ( ( rule__QuizPlatform__QuizzesAssignment_10 )* )
            {
            // InternalQuizDSL.g:1496:1: ( ( rule__QuizPlatform__QuizzesAssignment_10 )* )
            // InternalQuizDSL.g:1497:2: ( rule__QuizPlatform__QuizzesAssignment_10 )*
            {
             before(grammarAccess.getQuizPlatformAccess().getQuizzesAssignment_10()); 
            // InternalQuizDSL.g:1498:2: ( rule__QuizPlatform__QuizzesAssignment_10 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==33) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalQuizDSL.g:1498:3: rule__QuizPlatform__QuizzesAssignment_10
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__QuizPlatform__QuizzesAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getQuizPlatformAccess().getQuizzesAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__10__Impl"


    // $ANTLR start "rule__QuizPlatform__Group__11"
    // InternalQuizDSL.g:1506:1: rule__QuizPlatform__Group__11 : rule__QuizPlatform__Group__11__Impl ;
    public final void rule__QuizPlatform__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1510:1: ( rule__QuizPlatform__Group__11__Impl )
            // InternalQuizDSL.g:1511:2: rule__QuizPlatform__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizPlatform__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__11"


    // $ANTLR start "rule__QuizPlatform__Group__11__Impl"
    // InternalQuizDSL.g:1517:1: rule__QuizPlatform__Group__11__Impl : ( 'end' ) ;
    public final void rule__QuizPlatform__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1521:1: ( ( 'end' ) )
            // InternalQuizDSL.g:1522:1: ( 'end' )
            {
            // InternalQuizDSL.g:1522:1: ( 'end' )
            // InternalQuizDSL.g:1523:2: 'end'
            {
             before(grammarAccess.getQuizPlatformAccess().getEndKeyword_11()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getEndKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__Group__11__Impl"


    // $ANTLR start "rule__Quiz__Group__0"
    // InternalQuizDSL.g:1533:1: rule__Quiz__Group__0 : rule__Quiz__Group__0__Impl rule__Quiz__Group__1 ;
    public final void rule__Quiz__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1537:1: ( rule__Quiz__Group__0__Impl rule__Quiz__Group__1 )
            // InternalQuizDSL.g:1538:2: rule__Quiz__Group__0__Impl rule__Quiz__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Quiz__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__0"


    // $ANTLR start "rule__Quiz__Group__0__Impl"
    // InternalQuizDSL.g:1545:1: rule__Quiz__Group__0__Impl : ( 'quiz' ) ;
    public final void rule__Quiz__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1549:1: ( ( 'quiz' ) )
            // InternalQuizDSL.g:1550:1: ( 'quiz' )
            {
            // InternalQuizDSL.g:1550:1: ( 'quiz' )
            // InternalQuizDSL.g:1551:2: 'quiz'
            {
             before(grammarAccess.getQuizAccess().getQuizKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getQuizKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__0__Impl"


    // $ANTLR start "rule__Quiz__Group__1"
    // InternalQuizDSL.g:1560:1: rule__Quiz__Group__1 : rule__Quiz__Group__1__Impl rule__Quiz__Group__2 ;
    public final void rule__Quiz__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1564:1: ( rule__Quiz__Group__1__Impl rule__Quiz__Group__2 )
            // InternalQuizDSL.g:1565:2: rule__Quiz__Group__1__Impl rule__Quiz__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Quiz__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__1"


    // $ANTLR start "rule__Quiz__Group__1__Impl"
    // InternalQuizDSL.g:1572:1: rule__Quiz__Group__1__Impl : ( ( rule__Quiz__NameAssignment_1 ) ) ;
    public final void rule__Quiz__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1576:1: ( ( ( rule__Quiz__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:1577:1: ( ( rule__Quiz__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:1577:1: ( ( rule__Quiz__NameAssignment_1 ) )
            // InternalQuizDSL.g:1578:2: ( rule__Quiz__NameAssignment_1 )
            {
             before(grammarAccess.getQuizAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:1579:2: ( rule__Quiz__NameAssignment_1 )
            // InternalQuizDSL.g:1579:3: rule__Quiz__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__1__Impl"


    // $ANTLR start "rule__Quiz__Group__2"
    // InternalQuizDSL.g:1587:1: rule__Quiz__Group__2 : rule__Quiz__Group__2__Impl rule__Quiz__Group__3 ;
    public final void rule__Quiz__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1591:1: ( rule__Quiz__Group__2__Impl rule__Quiz__Group__3 )
            // InternalQuizDSL.g:1592:2: rule__Quiz__Group__2__Impl rule__Quiz__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Quiz__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__2"


    // $ANTLR start "rule__Quiz__Group__2__Impl"
    // InternalQuizDSL.g:1599:1: rule__Quiz__Group__2__Impl : ( 'label' ) ;
    public final void rule__Quiz__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1603:1: ( ( 'label' ) )
            // InternalQuizDSL.g:1604:1: ( 'label' )
            {
            // InternalQuizDSL.g:1604:1: ( 'label' )
            // InternalQuizDSL.g:1605:2: 'label'
            {
             before(grammarAccess.getQuizAccess().getLabelKeyword_2()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getLabelKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__2__Impl"


    // $ANTLR start "rule__Quiz__Group__3"
    // InternalQuizDSL.g:1614:1: rule__Quiz__Group__3 : rule__Quiz__Group__3__Impl rule__Quiz__Group__4 ;
    public final void rule__Quiz__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1618:1: ( rule__Quiz__Group__3__Impl rule__Quiz__Group__4 )
            // InternalQuizDSL.g:1619:2: rule__Quiz__Group__3__Impl rule__Quiz__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Quiz__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__3"


    // $ANTLR start "rule__Quiz__Group__3__Impl"
    // InternalQuizDSL.g:1626:1: rule__Quiz__Group__3__Impl : ( ( rule__Quiz__LabelAssignment_3 ) ) ;
    public final void rule__Quiz__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1630:1: ( ( ( rule__Quiz__LabelAssignment_3 ) ) )
            // InternalQuizDSL.g:1631:1: ( ( rule__Quiz__LabelAssignment_3 ) )
            {
            // InternalQuizDSL.g:1631:1: ( ( rule__Quiz__LabelAssignment_3 ) )
            // InternalQuizDSL.g:1632:2: ( rule__Quiz__LabelAssignment_3 )
            {
             before(grammarAccess.getQuizAccess().getLabelAssignment_3()); 
            // InternalQuizDSL.g:1633:2: ( rule__Quiz__LabelAssignment_3 )
            // InternalQuizDSL.g:1633:3: rule__Quiz__LabelAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__LabelAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getLabelAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__3__Impl"


    // $ANTLR start "rule__Quiz__Group__4"
    // InternalQuizDSL.g:1641:1: rule__Quiz__Group__4 : rule__Quiz__Group__4__Impl rule__Quiz__Group__5 ;
    public final void rule__Quiz__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1645:1: ( rule__Quiz__Group__4__Impl rule__Quiz__Group__5 )
            // InternalQuizDSL.g:1646:2: rule__Quiz__Group__4__Impl rule__Quiz__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__Quiz__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__4"


    // $ANTLR start "rule__Quiz__Group__4__Impl"
    // InternalQuizDSL.g:1653:1: rule__Quiz__Group__4__Impl : ( 'desc' ) ;
    public final void rule__Quiz__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1657:1: ( ( 'desc' ) )
            // InternalQuizDSL.g:1658:1: ( 'desc' )
            {
            // InternalQuizDSL.g:1658:1: ( 'desc' )
            // InternalQuizDSL.g:1659:2: 'desc'
            {
             before(grammarAccess.getQuizAccess().getDescKeyword_4()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getDescKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__4__Impl"


    // $ANTLR start "rule__Quiz__Group__5"
    // InternalQuizDSL.g:1668:1: rule__Quiz__Group__5 : rule__Quiz__Group__5__Impl rule__Quiz__Group__6 ;
    public final void rule__Quiz__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1672:1: ( rule__Quiz__Group__5__Impl rule__Quiz__Group__6 )
            // InternalQuizDSL.g:1673:2: rule__Quiz__Group__5__Impl rule__Quiz__Group__6
            {
            pushFollow(FOLLOW_24);
            rule__Quiz__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__5"


    // $ANTLR start "rule__Quiz__Group__5__Impl"
    // InternalQuizDSL.g:1680:1: rule__Quiz__Group__5__Impl : ( ( rule__Quiz__DescriptionAssignment_5 ) ) ;
    public final void rule__Quiz__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1684:1: ( ( ( rule__Quiz__DescriptionAssignment_5 ) ) )
            // InternalQuizDSL.g:1685:1: ( ( rule__Quiz__DescriptionAssignment_5 ) )
            {
            // InternalQuizDSL.g:1685:1: ( ( rule__Quiz__DescriptionAssignment_5 ) )
            // InternalQuizDSL.g:1686:2: ( rule__Quiz__DescriptionAssignment_5 )
            {
             before(grammarAccess.getQuizAccess().getDescriptionAssignment_5()); 
            // InternalQuizDSL.g:1687:2: ( rule__Quiz__DescriptionAssignment_5 )
            // InternalQuizDSL.g:1687:3: rule__Quiz__DescriptionAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__DescriptionAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getDescriptionAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__5__Impl"


    // $ANTLR start "rule__Quiz__Group__6"
    // InternalQuizDSL.g:1695:1: rule__Quiz__Group__6 : rule__Quiz__Group__6__Impl rule__Quiz__Group__7 ;
    public final void rule__Quiz__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1699:1: ( rule__Quiz__Group__6__Impl rule__Quiz__Group__7 )
            // InternalQuizDSL.g:1700:2: rule__Quiz__Group__6__Impl rule__Quiz__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Quiz__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__6"


    // $ANTLR start "rule__Quiz__Group__6__Impl"
    // InternalQuizDSL.g:1707:1: rule__Quiz__Group__6__Impl : ( 'icon' ) ;
    public final void rule__Quiz__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1711:1: ( ( 'icon' ) )
            // InternalQuizDSL.g:1712:1: ( 'icon' )
            {
            // InternalQuizDSL.g:1712:1: ( 'icon' )
            // InternalQuizDSL.g:1713:2: 'icon'
            {
             before(grammarAccess.getQuizAccess().getIconKeyword_6()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getIconKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__6__Impl"


    // $ANTLR start "rule__Quiz__Group__7"
    // InternalQuizDSL.g:1722:1: rule__Quiz__Group__7 : rule__Quiz__Group__7__Impl rule__Quiz__Group__8 ;
    public final void rule__Quiz__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1726:1: ( rule__Quiz__Group__7__Impl rule__Quiz__Group__8 )
            // InternalQuizDSL.g:1727:2: rule__Quiz__Group__7__Impl rule__Quiz__Group__8
            {
            pushFollow(FOLLOW_25);
            rule__Quiz__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__7"


    // $ANTLR start "rule__Quiz__Group__7__Impl"
    // InternalQuizDSL.g:1734:1: rule__Quiz__Group__7__Impl : ( ( rule__Quiz__IconAssignment_7 ) ) ;
    public final void rule__Quiz__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1738:1: ( ( ( rule__Quiz__IconAssignment_7 ) ) )
            // InternalQuizDSL.g:1739:1: ( ( rule__Quiz__IconAssignment_7 ) )
            {
            // InternalQuizDSL.g:1739:1: ( ( rule__Quiz__IconAssignment_7 ) )
            // InternalQuizDSL.g:1740:2: ( rule__Quiz__IconAssignment_7 )
            {
             before(grammarAccess.getQuizAccess().getIconAssignment_7()); 
            // InternalQuizDSL.g:1741:2: ( rule__Quiz__IconAssignment_7 )
            // InternalQuizDSL.g:1741:3: rule__Quiz__IconAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__IconAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getIconAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__7__Impl"


    // $ANTLR start "rule__Quiz__Group__8"
    // InternalQuizDSL.g:1749:1: rule__Quiz__Group__8 : rule__Quiz__Group__8__Impl rule__Quiz__Group__9 ;
    public final void rule__Quiz__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1753:1: ( rule__Quiz__Group__8__Impl rule__Quiz__Group__9 )
            // InternalQuizDSL.g:1754:2: rule__Quiz__Group__8__Impl rule__Quiz__Group__9
            {
            pushFollow(FOLLOW_26);
            rule__Quiz__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__8"


    // $ANTLR start "rule__Quiz__Group__8__Impl"
    // InternalQuizDSL.g:1761:1: rule__Quiz__Group__8__Impl : ( ( rule__Quiz__ConfigAssignment_8 ) ) ;
    public final void rule__Quiz__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1765:1: ( ( ( rule__Quiz__ConfigAssignment_8 ) ) )
            // InternalQuizDSL.g:1766:1: ( ( rule__Quiz__ConfigAssignment_8 ) )
            {
            // InternalQuizDSL.g:1766:1: ( ( rule__Quiz__ConfigAssignment_8 ) )
            // InternalQuizDSL.g:1767:2: ( rule__Quiz__ConfigAssignment_8 )
            {
             before(grammarAccess.getQuizAccess().getConfigAssignment_8()); 
            // InternalQuizDSL.g:1768:2: ( rule__Quiz__ConfigAssignment_8 )
            // InternalQuizDSL.g:1768:3: rule__Quiz__ConfigAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__ConfigAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getQuizAccess().getConfigAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__8__Impl"


    // $ANTLR start "rule__Quiz__Group__9"
    // InternalQuizDSL.g:1776:1: rule__Quiz__Group__9 : rule__Quiz__Group__9__Impl rule__Quiz__Group__10 ;
    public final void rule__Quiz__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1780:1: ( rule__Quiz__Group__9__Impl rule__Quiz__Group__10 )
            // InternalQuizDSL.g:1781:2: rule__Quiz__Group__9__Impl rule__Quiz__Group__10
            {
            pushFollow(FOLLOW_26);
            rule__Quiz__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Quiz__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__9"


    // $ANTLR start "rule__Quiz__Group__9__Impl"
    // InternalQuizDSL.g:1788:1: rule__Quiz__Group__9__Impl : ( ( rule__Quiz__QuestionsAssignment_9 )* ) ;
    public final void rule__Quiz__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1792:1: ( ( ( rule__Quiz__QuestionsAssignment_9 )* ) )
            // InternalQuizDSL.g:1793:1: ( ( rule__Quiz__QuestionsAssignment_9 )* )
            {
            // InternalQuizDSL.g:1793:1: ( ( rule__Quiz__QuestionsAssignment_9 )* )
            // InternalQuizDSL.g:1794:2: ( rule__Quiz__QuestionsAssignment_9 )*
            {
             before(grammarAccess.getQuizAccess().getQuestionsAssignment_9()); 
            // InternalQuizDSL.g:1795:2: ( rule__Quiz__QuestionsAssignment_9 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==41||(LA9_0>=46 && LA9_0<=47)||LA9_0==49) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalQuizDSL.g:1795:3: rule__Quiz__QuestionsAssignment_9
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Quiz__QuestionsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getQuizAccess().getQuestionsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__9__Impl"


    // $ANTLR start "rule__Quiz__Group__10"
    // InternalQuizDSL.g:1803:1: rule__Quiz__Group__10 : rule__Quiz__Group__10__Impl ;
    public final void rule__Quiz__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1807:1: ( rule__Quiz__Group__10__Impl )
            // InternalQuizDSL.g:1808:2: rule__Quiz__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Quiz__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__10"


    // $ANTLR start "rule__Quiz__Group__10__Impl"
    // InternalQuizDSL.g:1814:1: rule__Quiz__Group__10__Impl : ( 'end' ) ;
    public final void rule__Quiz__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1818:1: ( ( 'end' ) )
            // InternalQuizDSL.g:1819:1: ( 'end' )
            {
            // InternalQuizDSL.g:1819:1: ( 'end' )
            // InternalQuizDSL.g:1820:2: 'end'
            {
             before(grammarAccess.getQuizAccess().getEndKeyword_10()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getEndKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__Group__10__Impl"


    // $ANTLR start "rule__QuizConfig__Group__0"
    // InternalQuizDSL.g:1830:1: rule__QuizConfig__Group__0 : rule__QuizConfig__Group__0__Impl rule__QuizConfig__Group__1 ;
    public final void rule__QuizConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1834:1: ( rule__QuizConfig__Group__0__Impl rule__QuizConfig__Group__1 )
            // InternalQuizDSL.g:1835:2: rule__QuizConfig__Group__0__Impl rule__QuizConfig__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__QuizConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__0"


    // $ANTLR start "rule__QuizConfig__Group__0__Impl"
    // InternalQuizDSL.g:1842:1: rule__QuizConfig__Group__0__Impl : ( () ) ;
    public final void rule__QuizConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1846:1: ( ( () ) )
            // InternalQuizDSL.g:1847:1: ( () )
            {
            // InternalQuizDSL.g:1847:1: ( () )
            // InternalQuizDSL.g:1848:2: ()
            {
             before(grammarAccess.getQuizConfigAccess().getQuizConfigAction_0()); 
            // InternalQuizDSL.g:1849:2: ()
            // InternalQuizDSL.g:1849:3: 
            {
            }

             after(grammarAccess.getQuizConfigAccess().getQuizConfigAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__0__Impl"


    // $ANTLR start "rule__QuizConfig__Group__1"
    // InternalQuizDSL.g:1857:1: rule__QuizConfig__Group__1 : rule__QuizConfig__Group__1__Impl rule__QuizConfig__Group__2 ;
    public final void rule__QuizConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1861:1: ( rule__QuizConfig__Group__1__Impl rule__QuizConfig__Group__2 )
            // InternalQuizDSL.g:1862:2: rule__QuizConfig__Group__1__Impl rule__QuizConfig__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__1"


    // $ANTLR start "rule__QuizConfig__Group__1__Impl"
    // InternalQuizDSL.g:1869:1: rule__QuizConfig__Group__1__Impl : ( ( rule__QuizConfig__AccessAssignment_1 ) ) ;
    public final void rule__QuizConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1873:1: ( ( ( rule__QuizConfig__AccessAssignment_1 ) ) )
            // InternalQuizDSL.g:1874:1: ( ( rule__QuizConfig__AccessAssignment_1 ) )
            {
            // InternalQuizDSL.g:1874:1: ( ( rule__QuizConfig__AccessAssignment_1 ) )
            // InternalQuizDSL.g:1875:2: ( rule__QuizConfig__AccessAssignment_1 )
            {
             before(grammarAccess.getQuizConfigAccess().getAccessAssignment_1()); 
            // InternalQuizDSL.g:1876:2: ( rule__QuizConfig__AccessAssignment_1 )
            // InternalQuizDSL.g:1876:3: rule__QuizConfig__AccessAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__AccessAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getAccessAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__1__Impl"


    // $ANTLR start "rule__QuizConfig__Group__2"
    // InternalQuizDSL.g:1884:1: rule__QuizConfig__Group__2 : rule__QuizConfig__Group__2__Impl rule__QuizConfig__Group__3 ;
    public final void rule__QuizConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1888:1: ( rule__QuizConfig__Group__2__Impl rule__QuizConfig__Group__3 )
            // InternalQuizDSL.g:1889:2: rule__QuizConfig__Group__2__Impl rule__QuizConfig__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__2"


    // $ANTLR start "rule__QuizConfig__Group__2__Impl"
    // InternalQuizDSL.g:1896:1: rule__QuizConfig__Group__2__Impl : ( ( rule__QuizConfig__Group_2__0 )? ) ;
    public final void rule__QuizConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1900:1: ( ( ( rule__QuizConfig__Group_2__0 )? ) )
            // InternalQuizDSL.g:1901:1: ( ( rule__QuizConfig__Group_2__0 )? )
            {
            // InternalQuizDSL.g:1901:1: ( ( rule__QuizConfig__Group_2__0 )? )
            // InternalQuizDSL.g:1902:2: ( rule__QuizConfig__Group_2__0 )?
            {
             before(grammarAccess.getQuizConfigAccess().getGroup_2()); 
            // InternalQuizDSL.g:1903:2: ( rule__QuizConfig__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==37) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQuizDSL.g:1903:3: rule__QuizConfig__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__2__Impl"


    // $ANTLR start "rule__QuizConfig__Group__3"
    // InternalQuizDSL.g:1911:1: rule__QuizConfig__Group__3 : rule__QuizConfig__Group__3__Impl rule__QuizConfig__Group__4 ;
    public final void rule__QuizConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1915:1: ( rule__QuizConfig__Group__3__Impl rule__QuizConfig__Group__4 )
            // InternalQuizDSL.g:1916:2: rule__QuizConfig__Group__3__Impl rule__QuizConfig__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__3"


    // $ANTLR start "rule__QuizConfig__Group__3__Impl"
    // InternalQuizDSL.g:1923:1: rule__QuizConfig__Group__3__Impl : ( ( rule__QuizConfig__Group_3__0 )? ) ;
    public final void rule__QuizConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1927:1: ( ( ( rule__QuizConfig__Group_3__0 )? ) )
            // InternalQuizDSL.g:1928:1: ( ( rule__QuizConfig__Group_3__0 )? )
            {
            // InternalQuizDSL.g:1928:1: ( ( rule__QuizConfig__Group_3__0 )? )
            // InternalQuizDSL.g:1929:2: ( rule__QuizConfig__Group_3__0 )?
            {
             before(grammarAccess.getQuizConfigAccess().getGroup_3()); 
            // InternalQuizDSL.g:1930:2: ( rule__QuizConfig__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==39) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalQuizDSL.g:1930:3: rule__QuizConfig__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__3__Impl"


    // $ANTLR start "rule__QuizConfig__Group__4"
    // InternalQuizDSL.g:1938:1: rule__QuizConfig__Group__4 : rule__QuizConfig__Group__4__Impl rule__QuizConfig__Group__5 ;
    public final void rule__QuizConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1942:1: ( rule__QuizConfig__Group__4__Impl rule__QuizConfig__Group__5 )
            // InternalQuizDSL.g:1943:2: rule__QuizConfig__Group__4__Impl rule__QuizConfig__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__4"


    // $ANTLR start "rule__QuizConfig__Group__4__Impl"
    // InternalQuizDSL.g:1950:1: rule__QuizConfig__Group__4__Impl : ( ( rule__QuizConfig__Group_4__0 )? ) ;
    public final void rule__QuizConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1954:1: ( ( ( rule__QuizConfig__Group_4__0 )? ) )
            // InternalQuizDSL.g:1955:1: ( ( rule__QuizConfig__Group_4__0 )? )
            {
            // InternalQuizDSL.g:1955:1: ( ( rule__QuizConfig__Group_4__0 )? )
            // InternalQuizDSL.g:1956:2: ( rule__QuizConfig__Group_4__0 )?
            {
             before(grammarAccess.getQuizConfigAccess().getGroup_4()); 
            // InternalQuizDSL.g:1957:2: ( rule__QuizConfig__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_STRING) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // InternalQuizDSL.g:1957:3: rule__QuizConfig__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__4__Impl"


    // $ANTLR start "rule__QuizConfig__Group__5"
    // InternalQuizDSL.g:1965:1: rule__QuizConfig__Group__5 : rule__QuizConfig__Group__5__Impl rule__QuizConfig__Group__6 ;
    public final void rule__QuizConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1969:1: ( rule__QuizConfig__Group__5__Impl rule__QuizConfig__Group__6 )
            // InternalQuizDSL.g:1970:2: rule__QuizConfig__Group__5__Impl rule__QuizConfig__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__5"


    // $ANTLR start "rule__QuizConfig__Group__5__Impl"
    // InternalQuizDSL.g:1977:1: rule__QuizConfig__Group__5__Impl : ( ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )? ) ;
    public final void rule__QuizConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1981:1: ( ( ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )? ) )
            // InternalQuizDSL.g:1982:1: ( ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )? )
            {
            // InternalQuizDSL.g:1982:1: ( ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )? )
            // InternalQuizDSL.g:1983:2: ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )?
            {
             before(grammarAccess.getQuizConfigAccess().getShuffleQuestionsAssignment_5()); 
            // InternalQuizDSL.g:1984:2: ( rule__QuizConfig__ShuffleQuestionsAssignment_5 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==58) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalQuizDSL.g:1984:3: rule__QuizConfig__ShuffleQuestionsAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__ShuffleQuestionsAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getShuffleQuestionsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__5__Impl"


    // $ANTLR start "rule__QuizConfig__Group__6"
    // InternalQuizDSL.g:1992:1: rule__QuizConfig__Group__6 : rule__QuizConfig__Group__6__Impl rule__QuizConfig__Group__7 ;
    public final void rule__QuizConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:1996:1: ( rule__QuizConfig__Group__6__Impl rule__QuizConfig__Group__7 )
            // InternalQuizDSL.g:1997:2: rule__QuizConfig__Group__6__Impl rule__QuizConfig__Group__7
            {
            pushFollow(FOLLOW_28);
            rule__QuizConfig__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__6"


    // $ANTLR start "rule__QuizConfig__Group__6__Impl"
    // InternalQuizDSL.g:2004:1: rule__QuizConfig__Group__6__Impl : ( ( rule__QuizConfig__ShowResultAssignment_6 )? ) ;
    public final void rule__QuizConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2008:1: ( ( ( rule__QuizConfig__ShowResultAssignment_6 )? ) )
            // InternalQuizDSL.g:2009:1: ( ( rule__QuizConfig__ShowResultAssignment_6 )? )
            {
            // InternalQuizDSL.g:2009:1: ( ( rule__QuizConfig__ShowResultAssignment_6 )? )
            // InternalQuizDSL.g:2010:2: ( rule__QuizConfig__ShowResultAssignment_6 )?
            {
             before(grammarAccess.getQuizConfigAccess().getShowResultAssignment_6()); 
            // InternalQuizDSL.g:2011:2: ( rule__QuizConfig__ShowResultAssignment_6 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==59) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalQuizDSL.g:2011:3: rule__QuizConfig__ShowResultAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__ShowResultAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getShowResultAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__6__Impl"


    // $ANTLR start "rule__QuizConfig__Group__7"
    // InternalQuizDSL.g:2019:1: rule__QuizConfig__Group__7 : rule__QuizConfig__Group__7__Impl ;
    public final void rule__QuizConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2023:1: ( rule__QuizConfig__Group__7__Impl )
            // InternalQuizDSL.g:2024:2: rule__QuizConfig__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__7"


    // $ANTLR start "rule__QuizConfig__Group__7__Impl"
    // InternalQuizDSL.g:2030:1: rule__QuizConfig__Group__7__Impl : ( ( rule__QuizConfig__Group_7__0 )? ) ;
    public final void rule__QuizConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2034:1: ( ( ( rule__QuizConfig__Group_7__0 )? ) )
            // InternalQuizDSL.g:2035:1: ( ( rule__QuizConfig__Group_7__0 )? )
            {
            // InternalQuizDSL.g:2035:1: ( ( rule__QuizConfig__Group_7__0 )? )
            // InternalQuizDSL.g:2036:2: ( rule__QuizConfig__Group_7__0 )?
            {
             before(grammarAccess.getQuizConfigAccess().getGroup_7()); 
            // InternalQuizDSL.g:2037:2: ( rule__QuizConfig__Group_7__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==40) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalQuizDSL.g:2037:3: rule__QuizConfig__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuizConfig__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuizConfigAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group__7__Impl"


    // $ANTLR start "rule__QuizConfig__Group_2__0"
    // InternalQuizDSL.g:2046:1: rule__QuizConfig__Group_2__0 : rule__QuizConfig__Group_2__0__Impl rule__QuizConfig__Group_2__1 ;
    public final void rule__QuizConfig__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2050:1: ( rule__QuizConfig__Group_2__0__Impl rule__QuizConfig__Group_2__1 )
            // InternalQuizDSL.g:2051:2: rule__QuizConfig__Group_2__0__Impl rule__QuizConfig__Group_2__1
            {
            pushFollow(FOLLOW_29);
            rule__QuizConfig__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__0"


    // $ANTLR start "rule__QuizConfig__Group_2__0__Impl"
    // InternalQuizDSL.g:2058:1: rule__QuizConfig__Group_2__0__Impl : ( 'time' ) ;
    public final void rule__QuizConfig__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2062:1: ( ( 'time' ) )
            // InternalQuizDSL.g:2063:1: ( 'time' )
            {
            // InternalQuizDSL.g:2063:1: ( 'time' )
            // InternalQuizDSL.g:2064:2: 'time'
            {
             before(grammarAccess.getQuizConfigAccess().getTimeKeyword_2_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getTimeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__0__Impl"


    // $ANTLR start "rule__QuizConfig__Group_2__1"
    // InternalQuizDSL.g:2073:1: rule__QuizConfig__Group_2__1 : rule__QuizConfig__Group_2__1__Impl rule__QuizConfig__Group_2__2 ;
    public final void rule__QuizConfig__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2077:1: ( rule__QuizConfig__Group_2__1__Impl rule__QuizConfig__Group_2__2 )
            // InternalQuizDSL.g:2078:2: rule__QuizConfig__Group_2__1__Impl rule__QuizConfig__Group_2__2
            {
            pushFollow(FOLLOW_30);
            rule__QuizConfig__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__1"


    // $ANTLR start "rule__QuizConfig__Group_2__1__Impl"
    // InternalQuizDSL.g:2085:1: rule__QuizConfig__Group_2__1__Impl : ( ( rule__QuizConfig__DurationAssignment_2_1 ) ) ;
    public final void rule__QuizConfig__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2089:1: ( ( ( rule__QuizConfig__DurationAssignment_2_1 ) ) )
            // InternalQuizDSL.g:2090:1: ( ( rule__QuizConfig__DurationAssignment_2_1 ) )
            {
            // InternalQuizDSL.g:2090:1: ( ( rule__QuizConfig__DurationAssignment_2_1 ) )
            // InternalQuizDSL.g:2091:2: ( rule__QuizConfig__DurationAssignment_2_1 )
            {
             before(grammarAccess.getQuizConfigAccess().getDurationAssignment_2_1()); 
            // InternalQuizDSL.g:2092:2: ( rule__QuizConfig__DurationAssignment_2_1 )
            // InternalQuizDSL.g:2092:3: rule__QuizConfig__DurationAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__DurationAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getDurationAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__1__Impl"


    // $ANTLR start "rule__QuizConfig__Group_2__2"
    // InternalQuizDSL.g:2100:1: rule__QuizConfig__Group_2__2 : rule__QuizConfig__Group_2__2__Impl ;
    public final void rule__QuizConfig__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2104:1: ( rule__QuizConfig__Group_2__2__Impl )
            // InternalQuizDSL.g:2105:2: rule__QuizConfig__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__2"


    // $ANTLR start "rule__QuizConfig__Group_2__2__Impl"
    // InternalQuizDSL.g:2111:1: rule__QuizConfig__Group_2__2__Impl : ( 'min' ) ;
    public final void rule__QuizConfig__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2115:1: ( ( 'min' ) )
            // InternalQuizDSL.g:2116:1: ( 'min' )
            {
            // InternalQuizDSL.g:2116:1: ( 'min' )
            // InternalQuizDSL.g:2117:2: 'min'
            {
             before(grammarAccess.getQuizConfigAccess().getMinKeyword_2_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getMinKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_2__2__Impl"


    // $ANTLR start "rule__QuizConfig__Group_3__0"
    // InternalQuizDSL.g:2127:1: rule__QuizConfig__Group_3__0 : rule__QuizConfig__Group_3__0__Impl rule__QuizConfig__Group_3__1 ;
    public final void rule__QuizConfig__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2131:1: ( rule__QuizConfig__Group_3__0__Impl rule__QuizConfig__Group_3__1 )
            // InternalQuizDSL.g:2132:2: rule__QuizConfig__Group_3__0__Impl rule__QuizConfig__Group_3__1
            {
            pushFollow(FOLLOW_6);
            rule__QuizConfig__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_3__0"


    // $ANTLR start "rule__QuizConfig__Group_3__0__Impl"
    // InternalQuizDSL.g:2139:1: rule__QuizConfig__Group_3__0__Impl : ( 'start' ) ;
    public final void rule__QuizConfig__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2143:1: ( ( 'start' ) )
            // InternalQuizDSL.g:2144:1: ( 'start' )
            {
            // InternalQuizDSL.g:2144:1: ( 'start' )
            // InternalQuizDSL.g:2145:2: 'start'
            {
             before(grammarAccess.getQuizConfigAccess().getStartKeyword_3_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getStartKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_3__0__Impl"


    // $ANTLR start "rule__QuizConfig__Group_3__1"
    // InternalQuizDSL.g:2154:1: rule__QuizConfig__Group_3__1 : rule__QuizConfig__Group_3__1__Impl ;
    public final void rule__QuizConfig__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2158:1: ( rule__QuizConfig__Group_3__1__Impl )
            // InternalQuizDSL.g:2159:2: rule__QuizConfig__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_3__1"


    // $ANTLR start "rule__QuizConfig__Group_3__1__Impl"
    // InternalQuizDSL.g:2165:1: rule__QuizConfig__Group_3__1__Impl : ( ( rule__QuizConfig__StartTimeAssignment_3_1 ) ) ;
    public final void rule__QuizConfig__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2169:1: ( ( ( rule__QuizConfig__StartTimeAssignment_3_1 ) ) )
            // InternalQuizDSL.g:2170:1: ( ( rule__QuizConfig__StartTimeAssignment_3_1 ) )
            {
            // InternalQuizDSL.g:2170:1: ( ( rule__QuizConfig__StartTimeAssignment_3_1 ) )
            // InternalQuizDSL.g:2171:2: ( rule__QuizConfig__StartTimeAssignment_3_1 )
            {
             before(grammarAccess.getQuizConfigAccess().getStartTimeAssignment_3_1()); 
            // InternalQuizDSL.g:2172:2: ( rule__QuizConfig__StartTimeAssignment_3_1 )
            // InternalQuizDSL.g:2172:3: rule__QuizConfig__StartTimeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__StartTimeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getStartTimeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_3__1__Impl"


    // $ANTLR start "rule__QuizConfig__Group_4__0"
    // InternalQuizDSL.g:2181:1: rule__QuizConfig__Group_4__0 : rule__QuizConfig__Group_4__0__Impl rule__QuizConfig__Group_4__1 ;
    public final void rule__QuizConfig__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2185:1: ( rule__QuizConfig__Group_4__0__Impl rule__QuizConfig__Group_4__1 )
            // InternalQuizDSL.g:2186:2: rule__QuizConfig__Group_4__0__Impl rule__QuizConfig__Group_4__1
            {
            pushFollow(FOLLOW_6);
            rule__QuizConfig__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_4__0"


    // $ANTLR start "rule__QuizConfig__Group_4__0__Impl"
    // InternalQuizDSL.g:2193:1: rule__QuizConfig__Group_4__0__Impl : ( 'end' ) ;
    public final void rule__QuizConfig__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2197:1: ( ( 'end' ) )
            // InternalQuizDSL.g:2198:1: ( 'end' )
            {
            // InternalQuizDSL.g:2198:1: ( 'end' )
            // InternalQuizDSL.g:2199:2: 'end'
            {
             before(grammarAccess.getQuizConfigAccess().getEndKeyword_4_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getEndKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_4__0__Impl"


    // $ANTLR start "rule__QuizConfig__Group_4__1"
    // InternalQuizDSL.g:2208:1: rule__QuizConfig__Group_4__1 : rule__QuizConfig__Group_4__1__Impl ;
    public final void rule__QuizConfig__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2212:1: ( rule__QuizConfig__Group_4__1__Impl )
            // InternalQuizDSL.g:2213:2: rule__QuizConfig__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_4__1"


    // $ANTLR start "rule__QuizConfig__Group_4__1__Impl"
    // InternalQuizDSL.g:2219:1: rule__QuizConfig__Group_4__1__Impl : ( ( rule__QuizConfig__EndTimeAssignment_4_1 ) ) ;
    public final void rule__QuizConfig__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2223:1: ( ( ( rule__QuizConfig__EndTimeAssignment_4_1 ) ) )
            // InternalQuizDSL.g:2224:1: ( ( rule__QuizConfig__EndTimeAssignment_4_1 ) )
            {
            // InternalQuizDSL.g:2224:1: ( ( rule__QuizConfig__EndTimeAssignment_4_1 ) )
            // InternalQuizDSL.g:2225:2: ( rule__QuizConfig__EndTimeAssignment_4_1 )
            {
             before(grammarAccess.getQuizConfigAccess().getEndTimeAssignment_4_1()); 
            // InternalQuizDSL.g:2226:2: ( rule__QuizConfig__EndTimeAssignment_4_1 )
            // InternalQuizDSL.g:2226:3: rule__QuizConfig__EndTimeAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__EndTimeAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getEndTimeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_4__1__Impl"


    // $ANTLR start "rule__QuizConfig__Group_7__0"
    // InternalQuizDSL.g:2235:1: rule__QuizConfig__Group_7__0 : rule__QuizConfig__Group_7__0__Impl rule__QuizConfig__Group_7__1 ;
    public final void rule__QuizConfig__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2239:1: ( rule__QuizConfig__Group_7__0__Impl rule__QuizConfig__Group_7__1 )
            // InternalQuizDSL.g:2240:2: rule__QuizConfig__Group_7__0__Impl rule__QuizConfig__Group_7__1
            {
            pushFollow(FOLLOW_29);
            rule__QuizConfig__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_7__0"


    // $ANTLR start "rule__QuizConfig__Group_7__0__Impl"
    // InternalQuizDSL.g:2247:1: rule__QuizConfig__Group_7__0__Impl : ( 'score' ) ;
    public final void rule__QuizConfig__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2251:1: ( ( 'score' ) )
            // InternalQuizDSL.g:2252:1: ( 'score' )
            {
            // InternalQuizDSL.g:2252:1: ( 'score' )
            // InternalQuizDSL.g:2253:2: 'score'
            {
             before(grammarAccess.getQuizConfigAccess().getScoreKeyword_7_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getScoreKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_7__0__Impl"


    // $ANTLR start "rule__QuizConfig__Group_7__1"
    // InternalQuizDSL.g:2262:1: rule__QuizConfig__Group_7__1 : rule__QuizConfig__Group_7__1__Impl ;
    public final void rule__QuizConfig__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2266:1: ( rule__QuizConfig__Group_7__1__Impl )
            // InternalQuizDSL.g:2267:2: rule__QuizConfig__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_7__1"


    // $ANTLR start "rule__QuizConfig__Group_7__1__Impl"
    // InternalQuizDSL.g:2273:1: rule__QuizConfig__Group_7__1__Impl : ( ( rule__QuizConfig__TotalScoreAssignment_7_1 ) ) ;
    public final void rule__QuizConfig__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2277:1: ( ( ( rule__QuizConfig__TotalScoreAssignment_7_1 ) ) )
            // InternalQuizDSL.g:2278:1: ( ( rule__QuizConfig__TotalScoreAssignment_7_1 ) )
            {
            // InternalQuizDSL.g:2278:1: ( ( rule__QuizConfig__TotalScoreAssignment_7_1 ) )
            // InternalQuizDSL.g:2279:2: ( rule__QuizConfig__TotalScoreAssignment_7_1 )
            {
             before(grammarAccess.getQuizConfigAccess().getTotalScoreAssignment_7_1()); 
            // InternalQuizDSL.g:2280:2: ( rule__QuizConfig__TotalScoreAssignment_7_1 )
            // InternalQuizDSL.g:2280:3: rule__QuizConfig__TotalScoreAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizConfig__TotalScoreAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizConfigAccess().getTotalScoreAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__Group_7__1__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__0"
    // InternalQuizDSL.g:2289:1: rule__SingleChoiceQuestion__Group__0 : rule__SingleChoiceQuestion__Group__0__Impl rule__SingleChoiceQuestion__Group__1 ;
    public final void rule__SingleChoiceQuestion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2293:1: ( rule__SingleChoiceQuestion__Group__0__Impl rule__SingleChoiceQuestion__Group__1 )
            // InternalQuizDSL.g:2294:2: rule__SingleChoiceQuestion__Group__0__Impl rule__SingleChoiceQuestion__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__SingleChoiceQuestion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__0"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__0__Impl"
    // InternalQuizDSL.g:2301:1: rule__SingleChoiceQuestion__Group__0__Impl : ( 'single_choice' ) ;
    public final void rule__SingleChoiceQuestion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2305:1: ( ( 'single_choice' ) )
            // InternalQuizDSL.g:2306:1: ( 'single_choice' )
            {
            // InternalQuizDSL.g:2306:1: ( 'single_choice' )
            // InternalQuizDSL.g:2307:2: 'single_choice'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getSingle_choiceKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getSingle_choiceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__0__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__1"
    // InternalQuizDSL.g:2316:1: rule__SingleChoiceQuestion__Group__1 : rule__SingleChoiceQuestion__Group__1__Impl rule__SingleChoiceQuestion__Group__2 ;
    public final void rule__SingleChoiceQuestion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2320:1: ( rule__SingleChoiceQuestion__Group__1__Impl rule__SingleChoiceQuestion__Group__2 )
            // InternalQuizDSL.g:2321:2: rule__SingleChoiceQuestion__Group__1__Impl rule__SingleChoiceQuestion__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__SingleChoiceQuestion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__1"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__1__Impl"
    // InternalQuizDSL.g:2328:1: rule__SingleChoiceQuestion__Group__1__Impl : ( ( rule__SingleChoiceQuestion__NameAssignment_1 ) ) ;
    public final void rule__SingleChoiceQuestion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2332:1: ( ( ( rule__SingleChoiceQuestion__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:2333:1: ( ( rule__SingleChoiceQuestion__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:2333:1: ( ( rule__SingleChoiceQuestion__NameAssignment_1 ) )
            // InternalQuizDSL.g:2334:2: ( rule__SingleChoiceQuestion__NameAssignment_1 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:2335:2: ( rule__SingleChoiceQuestion__NameAssignment_1 )
            // InternalQuizDSL.g:2335:3: rule__SingleChoiceQuestion__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__1__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__2"
    // InternalQuizDSL.g:2343:1: rule__SingleChoiceQuestion__Group__2 : rule__SingleChoiceQuestion__Group__2__Impl rule__SingleChoiceQuestion__Group__3 ;
    public final void rule__SingleChoiceQuestion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2347:1: ( rule__SingleChoiceQuestion__Group__2__Impl rule__SingleChoiceQuestion__Group__3 )
            // InternalQuizDSL.g:2348:2: rule__SingleChoiceQuestion__Group__2__Impl rule__SingleChoiceQuestion__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__SingleChoiceQuestion__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__2"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__2__Impl"
    // InternalQuizDSL.g:2355:1: rule__SingleChoiceQuestion__Group__2__Impl : ( 'text' ) ;
    public final void rule__SingleChoiceQuestion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2359:1: ( ( 'text' ) )
            // InternalQuizDSL.g:2360:1: ( 'text' )
            {
            // InternalQuizDSL.g:2360:1: ( 'text' )
            // InternalQuizDSL.g:2361:2: 'text'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getTextKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__2__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__3"
    // InternalQuizDSL.g:2370:1: rule__SingleChoiceQuestion__Group__3 : rule__SingleChoiceQuestion__Group__3__Impl rule__SingleChoiceQuestion__Group__4 ;
    public final void rule__SingleChoiceQuestion__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2374:1: ( rule__SingleChoiceQuestion__Group__3__Impl rule__SingleChoiceQuestion__Group__4 )
            // InternalQuizDSL.g:2375:2: rule__SingleChoiceQuestion__Group__3__Impl rule__SingleChoiceQuestion__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__SingleChoiceQuestion__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__3"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__3__Impl"
    // InternalQuizDSL.g:2382:1: rule__SingleChoiceQuestion__Group__3__Impl : ( ( rule__SingleChoiceQuestion__TextAssignment_3 ) ) ;
    public final void rule__SingleChoiceQuestion__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2386:1: ( ( ( rule__SingleChoiceQuestion__TextAssignment_3 ) ) )
            // InternalQuizDSL.g:2387:1: ( ( rule__SingleChoiceQuestion__TextAssignment_3 ) )
            {
            // InternalQuizDSL.g:2387:1: ( ( rule__SingleChoiceQuestion__TextAssignment_3 ) )
            // InternalQuizDSL.g:2388:2: ( rule__SingleChoiceQuestion__TextAssignment_3 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getTextAssignment_3()); 
            // InternalQuizDSL.g:2389:2: ( rule__SingleChoiceQuestion__TextAssignment_3 )
            // InternalQuizDSL.g:2389:3: rule__SingleChoiceQuestion__TextAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__TextAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getTextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__3__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__4"
    // InternalQuizDSL.g:2397:1: rule__SingleChoiceQuestion__Group__4 : rule__SingleChoiceQuestion__Group__4__Impl rule__SingleChoiceQuestion__Group__5 ;
    public final void rule__SingleChoiceQuestion__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2401:1: ( rule__SingleChoiceQuestion__Group__4__Impl rule__SingleChoiceQuestion__Group__5 )
            // InternalQuizDSL.g:2402:2: rule__SingleChoiceQuestion__Group__4__Impl rule__SingleChoiceQuestion__Group__5
            {
            pushFollow(FOLLOW_31);
            rule__SingleChoiceQuestion__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__4"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__4__Impl"
    // InternalQuizDSL.g:2409:1: rule__SingleChoiceQuestion__Group__4__Impl : ( ( rule__SingleChoiceQuestion__Group_4__0 )? ) ;
    public final void rule__SingleChoiceQuestion__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2413:1: ( ( ( rule__SingleChoiceQuestion__Group_4__0 )? ) )
            // InternalQuizDSL.g:2414:1: ( ( rule__SingleChoiceQuestion__Group_4__0 )? )
            {
            // InternalQuizDSL.g:2414:1: ( ( rule__SingleChoiceQuestion__Group_4__0 )? )
            // InternalQuizDSL.g:2415:2: ( rule__SingleChoiceQuestion__Group_4__0 )?
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getGroup_4()); 
            // InternalQuizDSL.g:2416:2: ( rule__SingleChoiceQuestion__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==44) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalQuizDSL.g:2416:3: rule__SingleChoiceQuestion__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleChoiceQuestion__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__4__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__5"
    // InternalQuizDSL.g:2424:1: rule__SingleChoiceQuestion__Group__5 : rule__SingleChoiceQuestion__Group__5__Impl rule__SingleChoiceQuestion__Group__6 ;
    public final void rule__SingleChoiceQuestion__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2428:1: ( rule__SingleChoiceQuestion__Group__5__Impl rule__SingleChoiceQuestion__Group__6 )
            // InternalQuizDSL.g:2429:2: rule__SingleChoiceQuestion__Group__5__Impl rule__SingleChoiceQuestion__Group__6
            {
            pushFollow(FOLLOW_31);
            rule__SingleChoiceQuestion__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__5"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__5__Impl"
    // InternalQuizDSL.g:2436:1: rule__SingleChoiceQuestion__Group__5__Impl : ( ( rule__SingleChoiceQuestion__Group_5__0 )? ) ;
    public final void rule__SingleChoiceQuestion__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2440:1: ( ( ( rule__SingleChoiceQuestion__Group_5__0 )? ) )
            // InternalQuizDSL.g:2441:1: ( ( rule__SingleChoiceQuestion__Group_5__0 )? )
            {
            // InternalQuizDSL.g:2441:1: ( ( rule__SingleChoiceQuestion__Group_5__0 )? )
            // InternalQuizDSL.g:2442:2: ( rule__SingleChoiceQuestion__Group_5__0 )?
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getGroup_5()); 
            // InternalQuizDSL.g:2443:2: ( rule__SingleChoiceQuestion__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==45) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalQuizDSL.g:2443:3: rule__SingleChoiceQuestion__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SingleChoiceQuestion__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__5__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__6"
    // InternalQuizDSL.g:2451:1: rule__SingleChoiceQuestion__Group__6 : rule__SingleChoiceQuestion__Group__6__Impl rule__SingleChoiceQuestion__Group__7 ;
    public final void rule__SingleChoiceQuestion__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2455:1: ( rule__SingleChoiceQuestion__Group__6__Impl rule__SingleChoiceQuestion__Group__7 )
            // InternalQuizDSL.g:2456:2: rule__SingleChoiceQuestion__Group__6__Impl rule__SingleChoiceQuestion__Group__7
            {
            pushFollow(FOLLOW_4);
            rule__SingleChoiceQuestion__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__6"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__6__Impl"
    // InternalQuizDSL.g:2463:1: rule__SingleChoiceQuestion__Group__6__Impl : ( 'options' ) ;
    public final void rule__SingleChoiceQuestion__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2467:1: ( ( 'options' ) )
            // InternalQuizDSL.g:2468:1: ( 'options' )
            {
            // InternalQuizDSL.g:2468:1: ( 'options' )
            // InternalQuizDSL.g:2469:2: 'options'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getOptionsKeyword_6()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getOptionsKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__6__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__7"
    // InternalQuizDSL.g:2478:1: rule__SingleChoiceQuestion__Group__7 : rule__SingleChoiceQuestion__Group__7__Impl rule__SingleChoiceQuestion__Group__8 ;
    public final void rule__SingleChoiceQuestion__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2482:1: ( rule__SingleChoiceQuestion__Group__7__Impl rule__SingleChoiceQuestion__Group__8 )
            // InternalQuizDSL.g:2483:2: rule__SingleChoiceQuestion__Group__7__Impl rule__SingleChoiceQuestion__Group__8
            {
            pushFollow(FOLLOW_32);
            rule__SingleChoiceQuestion__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__7"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__7__Impl"
    // InternalQuizDSL.g:2490:1: rule__SingleChoiceQuestion__Group__7__Impl : ( ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) ) ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* ) ) ;
    public final void rule__SingleChoiceQuestion__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2494:1: ( ( ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) ) ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* ) ) )
            // InternalQuizDSL.g:2495:1: ( ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) ) ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* ) )
            {
            // InternalQuizDSL.g:2495:1: ( ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) ) ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* ) )
            // InternalQuizDSL.g:2496:2: ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) ) ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* )
            {
            // InternalQuizDSL.g:2496:2: ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 ) )
            // InternalQuizDSL.g:2497:3: ( rule__SingleChoiceQuestion__OptionsAssignment_7 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getOptionsAssignment_7()); 
            // InternalQuizDSL.g:2498:3: ( rule__SingleChoiceQuestion__OptionsAssignment_7 )
            // InternalQuizDSL.g:2498:4: rule__SingleChoiceQuestion__OptionsAssignment_7
            {
            pushFollow(FOLLOW_33);
            rule__SingleChoiceQuestion__OptionsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getOptionsAssignment_7()); 

            }

            // InternalQuizDSL.g:2501:2: ( ( rule__SingleChoiceQuestion__OptionsAssignment_7 )* )
            // InternalQuizDSL.g:2502:3: ( rule__SingleChoiceQuestion__OptionsAssignment_7 )*
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getOptionsAssignment_7()); 
            // InternalQuizDSL.g:2503:3: ( rule__SingleChoiceQuestion__OptionsAssignment_7 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalQuizDSL.g:2503:4: rule__SingleChoiceQuestion__OptionsAssignment_7
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__SingleChoiceQuestion__OptionsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSingleChoiceQuestionAccess().getOptionsAssignment_7()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__7__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__8"
    // InternalQuizDSL.g:2512:1: rule__SingleChoiceQuestion__Group__8 : rule__SingleChoiceQuestion__Group__8__Impl rule__SingleChoiceQuestion__Group__9 ;
    public final void rule__SingleChoiceQuestion__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2516:1: ( rule__SingleChoiceQuestion__Group__8__Impl rule__SingleChoiceQuestion__Group__9 )
            // InternalQuizDSL.g:2517:2: rule__SingleChoiceQuestion__Group__8__Impl rule__SingleChoiceQuestion__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__SingleChoiceQuestion__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__8"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__8__Impl"
    // InternalQuizDSL.g:2524:1: rule__SingleChoiceQuestion__Group__8__Impl : ( 'correct' ) ;
    public final void rule__SingleChoiceQuestion__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2528:1: ( ( 'correct' ) )
            // InternalQuizDSL.g:2529:1: ( 'correct' )
            {
            // InternalQuizDSL.g:2529:1: ( 'correct' )
            // InternalQuizDSL.g:2530:2: 'correct'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getCorrectKeyword_8()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getCorrectKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__8__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__9"
    // InternalQuizDSL.g:2539:1: rule__SingleChoiceQuestion__Group__9 : rule__SingleChoiceQuestion__Group__9__Impl rule__SingleChoiceQuestion__Group__10 ;
    public final void rule__SingleChoiceQuestion__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2543:1: ( rule__SingleChoiceQuestion__Group__9__Impl rule__SingleChoiceQuestion__Group__10 )
            // InternalQuizDSL.g:2544:2: rule__SingleChoiceQuestion__Group__9__Impl rule__SingleChoiceQuestion__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__SingleChoiceQuestion__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__9"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__9__Impl"
    // InternalQuizDSL.g:2551:1: rule__SingleChoiceQuestion__Group__9__Impl : ( ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 ) ) ;
    public final void rule__SingleChoiceQuestion__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2555:1: ( ( ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 ) ) )
            // InternalQuizDSL.g:2556:1: ( ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 ) )
            {
            // InternalQuizDSL.g:2556:1: ( ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 ) )
            // InternalQuizDSL.g:2557:2: ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionAssignment_9()); 
            // InternalQuizDSL.g:2558:2: ( rule__SingleChoiceQuestion__CorrectOptionAssignment_9 )
            // InternalQuizDSL.g:2558:3: rule__SingleChoiceQuestion__CorrectOptionAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__CorrectOptionAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__9__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__10"
    // InternalQuizDSL.g:2566:1: rule__SingleChoiceQuestion__Group__10 : rule__SingleChoiceQuestion__Group__10__Impl ;
    public final void rule__SingleChoiceQuestion__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2570:1: ( rule__SingleChoiceQuestion__Group__10__Impl )
            // InternalQuizDSL.g:2571:2: rule__SingleChoiceQuestion__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__10"


    // $ANTLR start "rule__SingleChoiceQuestion__Group__10__Impl"
    // InternalQuizDSL.g:2577:1: rule__SingleChoiceQuestion__Group__10__Impl : ( 'end' ) ;
    public final void rule__SingleChoiceQuestion__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2581:1: ( ( 'end' ) )
            // InternalQuizDSL.g:2582:1: ( 'end' )
            {
            // InternalQuizDSL.g:2582:1: ( 'end' )
            // InternalQuizDSL.g:2583:2: 'end'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getEndKeyword_10()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getEndKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group__10__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_4__0"
    // InternalQuizDSL.g:2593:1: rule__SingleChoiceQuestion__Group_4__0 : rule__SingleChoiceQuestion__Group_4__0__Impl rule__SingleChoiceQuestion__Group_4__1 ;
    public final void rule__SingleChoiceQuestion__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2597:1: ( rule__SingleChoiceQuestion__Group_4__0__Impl rule__SingleChoiceQuestion__Group_4__1 )
            // InternalQuizDSL.g:2598:2: rule__SingleChoiceQuestion__Group_4__0__Impl rule__SingleChoiceQuestion__Group_4__1
            {
            pushFollow(FOLLOW_29);
            rule__SingleChoiceQuestion__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_4__0"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_4__0__Impl"
    // InternalQuizDSL.g:2605:1: rule__SingleChoiceQuestion__Group_4__0__Impl : ( 'val' ) ;
    public final void rule__SingleChoiceQuestion__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2609:1: ( ( 'val' ) )
            // InternalQuizDSL.g:2610:1: ( 'val' )
            {
            // InternalQuizDSL.g:2610:1: ( 'val' )
            // InternalQuizDSL.g:2611:2: 'val'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getValKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getValKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_4__0__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_4__1"
    // InternalQuizDSL.g:2620:1: rule__SingleChoiceQuestion__Group_4__1 : rule__SingleChoiceQuestion__Group_4__1__Impl ;
    public final void rule__SingleChoiceQuestion__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2624:1: ( rule__SingleChoiceQuestion__Group_4__1__Impl )
            // InternalQuizDSL.g:2625:2: rule__SingleChoiceQuestion__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_4__1"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_4__1__Impl"
    // InternalQuizDSL.g:2631:1: rule__SingleChoiceQuestion__Group_4__1__Impl : ( ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 ) ) ;
    public final void rule__SingleChoiceQuestion__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2635:1: ( ( ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 ) ) )
            // InternalQuizDSL.g:2636:1: ( ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 ) )
            {
            // InternalQuizDSL.g:2636:1: ( ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 ) )
            // InternalQuizDSL.g:2637:2: ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getScoreAssignment_4_1()); 
            // InternalQuizDSL.g:2638:2: ( rule__SingleChoiceQuestion__ScoreAssignment_4_1 )
            // InternalQuizDSL.g:2638:3: rule__SingleChoiceQuestion__ScoreAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__ScoreAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getScoreAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_4__1__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_5__0"
    // InternalQuizDSL.g:2647:1: rule__SingleChoiceQuestion__Group_5__0 : rule__SingleChoiceQuestion__Group_5__0__Impl rule__SingleChoiceQuestion__Group_5__1 ;
    public final void rule__SingleChoiceQuestion__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2651:1: ( rule__SingleChoiceQuestion__Group_5__0__Impl rule__SingleChoiceQuestion__Group_5__1 )
            // InternalQuizDSL.g:2652:2: rule__SingleChoiceQuestion__Group_5__0__Impl rule__SingleChoiceQuestion__Group_5__1
            {
            pushFollow(FOLLOW_6);
            rule__SingleChoiceQuestion__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_5__0"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_5__0__Impl"
    // InternalQuizDSL.g:2659:1: rule__SingleChoiceQuestion__Group_5__0__Impl : ( 'media' ) ;
    public final void rule__SingleChoiceQuestion__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2663:1: ( ( 'media' ) )
            // InternalQuizDSL.g:2664:1: ( 'media' )
            {
            // InternalQuizDSL.g:2664:1: ( 'media' )
            // InternalQuizDSL.g:2665:2: 'media'
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getMediaKeyword_5_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getMediaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_5__0__Impl"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_5__1"
    // InternalQuizDSL.g:2674:1: rule__SingleChoiceQuestion__Group_5__1 : rule__SingleChoiceQuestion__Group_5__1__Impl ;
    public final void rule__SingleChoiceQuestion__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2678:1: ( rule__SingleChoiceQuestion__Group_5__1__Impl )
            // InternalQuizDSL.g:2679:2: rule__SingleChoiceQuestion__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_5__1"


    // $ANTLR start "rule__SingleChoiceQuestion__Group_5__1__Impl"
    // InternalQuizDSL.g:2685:1: rule__SingleChoiceQuestion__Group_5__1__Impl : ( ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 ) ) ;
    public final void rule__SingleChoiceQuestion__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2689:1: ( ( ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 ) ) )
            // InternalQuizDSL.g:2690:1: ( ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 ) )
            {
            // InternalQuizDSL.g:2690:1: ( ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 ) )
            // InternalQuizDSL.g:2691:2: ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getMediaUrlAssignment_5_1()); 
            // InternalQuizDSL.g:2692:2: ( rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 )
            // InternalQuizDSL.g:2692:3: rule__SingleChoiceQuestion__MediaUrlAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__SingleChoiceQuestion__MediaUrlAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getMediaUrlAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__Group_5__1__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__0"
    // InternalQuizDSL.g:2701:1: rule__MultipleChoiceQuestion__Group__0 : rule__MultipleChoiceQuestion__Group__0__Impl rule__MultipleChoiceQuestion__Group__1 ;
    public final void rule__MultipleChoiceQuestion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2705:1: ( rule__MultipleChoiceQuestion__Group__0__Impl rule__MultipleChoiceQuestion__Group__1 )
            // InternalQuizDSL.g:2706:2: rule__MultipleChoiceQuestion__Group__0__Impl rule__MultipleChoiceQuestion__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__MultipleChoiceQuestion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__0"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__0__Impl"
    // InternalQuizDSL.g:2713:1: rule__MultipleChoiceQuestion__Group__0__Impl : ( 'multi_choice' ) ;
    public final void rule__MultipleChoiceQuestion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2717:1: ( ( 'multi_choice' ) )
            // InternalQuizDSL.g:2718:1: ( 'multi_choice' )
            {
            // InternalQuizDSL.g:2718:1: ( 'multi_choice' )
            // InternalQuizDSL.g:2719:2: 'multi_choice'
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getMulti_choiceKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getMulti_choiceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__0__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__1"
    // InternalQuizDSL.g:2728:1: rule__MultipleChoiceQuestion__Group__1 : rule__MultipleChoiceQuestion__Group__1__Impl rule__MultipleChoiceQuestion__Group__2 ;
    public final void rule__MultipleChoiceQuestion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2732:1: ( rule__MultipleChoiceQuestion__Group__1__Impl rule__MultipleChoiceQuestion__Group__2 )
            // InternalQuizDSL.g:2733:2: rule__MultipleChoiceQuestion__Group__1__Impl rule__MultipleChoiceQuestion__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__MultipleChoiceQuestion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__1"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__1__Impl"
    // InternalQuizDSL.g:2740:1: rule__MultipleChoiceQuestion__Group__1__Impl : ( ( rule__MultipleChoiceQuestion__NameAssignment_1 ) ) ;
    public final void rule__MultipleChoiceQuestion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2744:1: ( ( ( rule__MultipleChoiceQuestion__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:2745:1: ( ( rule__MultipleChoiceQuestion__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:2745:1: ( ( rule__MultipleChoiceQuestion__NameAssignment_1 ) )
            // InternalQuizDSL.g:2746:2: ( rule__MultipleChoiceQuestion__NameAssignment_1 )
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:2747:2: ( rule__MultipleChoiceQuestion__NameAssignment_1 )
            // InternalQuizDSL.g:2747:3: rule__MultipleChoiceQuestion__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__1__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__2"
    // InternalQuizDSL.g:2755:1: rule__MultipleChoiceQuestion__Group__2 : rule__MultipleChoiceQuestion__Group__2__Impl rule__MultipleChoiceQuestion__Group__3 ;
    public final void rule__MultipleChoiceQuestion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2759:1: ( rule__MultipleChoiceQuestion__Group__2__Impl rule__MultipleChoiceQuestion__Group__3 )
            // InternalQuizDSL.g:2760:2: rule__MultipleChoiceQuestion__Group__2__Impl rule__MultipleChoiceQuestion__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__MultipleChoiceQuestion__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__2"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__2__Impl"
    // InternalQuizDSL.g:2767:1: rule__MultipleChoiceQuestion__Group__2__Impl : ( 'text' ) ;
    public final void rule__MultipleChoiceQuestion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2771:1: ( ( 'text' ) )
            // InternalQuizDSL.g:2772:1: ( 'text' )
            {
            // InternalQuizDSL.g:2772:1: ( 'text' )
            // InternalQuizDSL.g:2773:2: 'text'
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getTextKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__2__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__3"
    // InternalQuizDSL.g:2782:1: rule__MultipleChoiceQuestion__Group__3 : rule__MultipleChoiceQuestion__Group__3__Impl rule__MultipleChoiceQuestion__Group__4 ;
    public final void rule__MultipleChoiceQuestion__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2786:1: ( rule__MultipleChoiceQuestion__Group__3__Impl rule__MultipleChoiceQuestion__Group__4 )
            // InternalQuizDSL.g:2787:2: rule__MultipleChoiceQuestion__Group__3__Impl rule__MultipleChoiceQuestion__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__MultipleChoiceQuestion__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__3"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__3__Impl"
    // InternalQuizDSL.g:2794:1: rule__MultipleChoiceQuestion__Group__3__Impl : ( ( rule__MultipleChoiceQuestion__TextAssignment_3 ) ) ;
    public final void rule__MultipleChoiceQuestion__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2798:1: ( ( ( rule__MultipleChoiceQuestion__TextAssignment_3 ) ) )
            // InternalQuizDSL.g:2799:1: ( ( rule__MultipleChoiceQuestion__TextAssignment_3 ) )
            {
            // InternalQuizDSL.g:2799:1: ( ( rule__MultipleChoiceQuestion__TextAssignment_3 ) )
            // InternalQuizDSL.g:2800:2: ( rule__MultipleChoiceQuestion__TextAssignment_3 )
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getTextAssignment_3()); 
            // InternalQuizDSL.g:2801:2: ( rule__MultipleChoiceQuestion__TextAssignment_3 )
            // InternalQuizDSL.g:2801:3: rule__MultipleChoiceQuestion__TextAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__TextAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getTextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__3__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__4"
    // InternalQuizDSL.g:2809:1: rule__MultipleChoiceQuestion__Group__4 : rule__MultipleChoiceQuestion__Group__4__Impl rule__MultipleChoiceQuestion__Group__5 ;
    public final void rule__MultipleChoiceQuestion__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2813:1: ( rule__MultipleChoiceQuestion__Group__4__Impl rule__MultipleChoiceQuestion__Group__5 )
            // InternalQuizDSL.g:2814:2: rule__MultipleChoiceQuestion__Group__4__Impl rule__MultipleChoiceQuestion__Group__5
            {
            pushFollow(FOLLOW_34);
            rule__MultipleChoiceQuestion__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__4"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__4__Impl"
    // InternalQuizDSL.g:2821:1: rule__MultipleChoiceQuestion__Group__4__Impl : ( ( rule__MultipleChoiceQuestion__Group_4__0 )? ) ;
    public final void rule__MultipleChoiceQuestion__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2825:1: ( ( ( rule__MultipleChoiceQuestion__Group_4__0 )? ) )
            // InternalQuizDSL.g:2826:1: ( ( rule__MultipleChoiceQuestion__Group_4__0 )? )
            {
            // InternalQuizDSL.g:2826:1: ( ( rule__MultipleChoiceQuestion__Group_4__0 )? )
            // InternalQuizDSL.g:2827:2: ( rule__MultipleChoiceQuestion__Group_4__0 )?
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getGroup_4()); 
            // InternalQuizDSL.g:2828:2: ( rule__MultipleChoiceQuestion__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==44) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalQuizDSL.g:2828:3: rule__MultipleChoiceQuestion__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultipleChoiceQuestion__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__4__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__5"
    // InternalQuizDSL.g:2836:1: rule__MultipleChoiceQuestion__Group__5 : rule__MultipleChoiceQuestion__Group__5__Impl rule__MultipleChoiceQuestion__Group__6 ;
    public final void rule__MultipleChoiceQuestion__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2840:1: ( rule__MultipleChoiceQuestion__Group__5__Impl rule__MultipleChoiceQuestion__Group__6 )
            // InternalQuizDSL.g:2841:2: rule__MultipleChoiceQuestion__Group__5__Impl rule__MultipleChoiceQuestion__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__MultipleChoiceQuestion__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__5"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__5__Impl"
    // InternalQuizDSL.g:2848:1: rule__MultipleChoiceQuestion__Group__5__Impl : ( 'options' ) ;
    public final void rule__MultipleChoiceQuestion__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2852:1: ( ( 'options' ) )
            // InternalQuizDSL.g:2853:1: ( 'options' )
            {
            // InternalQuizDSL.g:2853:1: ( 'options' )
            // InternalQuizDSL.g:2854:2: 'options'
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsKeyword_5()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__5__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__6"
    // InternalQuizDSL.g:2863:1: rule__MultipleChoiceQuestion__Group__6 : rule__MultipleChoiceQuestion__Group__6__Impl rule__MultipleChoiceQuestion__Group__7 ;
    public final void rule__MultipleChoiceQuestion__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2867:1: ( rule__MultipleChoiceQuestion__Group__6__Impl rule__MultipleChoiceQuestion__Group__7 )
            // InternalQuizDSL.g:2868:2: rule__MultipleChoiceQuestion__Group__6__Impl rule__MultipleChoiceQuestion__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__MultipleChoiceQuestion__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__6"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__6__Impl"
    // InternalQuizDSL.g:2875:1: rule__MultipleChoiceQuestion__Group__6__Impl : ( ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) ) ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* ) ) ;
    public final void rule__MultipleChoiceQuestion__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2879:1: ( ( ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) ) ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* ) ) )
            // InternalQuizDSL.g:2880:1: ( ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) ) ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* ) )
            {
            // InternalQuizDSL.g:2880:1: ( ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) ) ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* ) )
            // InternalQuizDSL.g:2881:2: ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) ) ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* )
            {
            // InternalQuizDSL.g:2881:2: ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 ) )
            // InternalQuizDSL.g:2882:3: ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsAssignment_6()); 
            // InternalQuizDSL.g:2883:3: ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )
            // InternalQuizDSL.g:2883:4: rule__MultipleChoiceQuestion__OptionsAssignment_6
            {
            pushFollow(FOLLOW_33);
            rule__MultipleChoiceQuestion__OptionsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsAssignment_6()); 

            }

            // InternalQuizDSL.g:2886:2: ( ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )* )
            // InternalQuizDSL.g:2887:3: ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )*
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsAssignment_6()); 
            // InternalQuizDSL.g:2888:3: ( rule__MultipleChoiceQuestion__OptionsAssignment_6 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalQuizDSL.g:2888:4: rule__MultipleChoiceQuestion__OptionsAssignment_6
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__MultipleChoiceQuestion__OptionsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsAssignment_6()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__6__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__7"
    // InternalQuizDSL.g:2897:1: rule__MultipleChoiceQuestion__Group__7 : rule__MultipleChoiceQuestion__Group__7__Impl ;
    public final void rule__MultipleChoiceQuestion__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2901:1: ( rule__MultipleChoiceQuestion__Group__7__Impl )
            // InternalQuizDSL.g:2902:2: rule__MultipleChoiceQuestion__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__7"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group__7__Impl"
    // InternalQuizDSL.g:2908:1: rule__MultipleChoiceQuestion__Group__7__Impl : ( 'end' ) ;
    public final void rule__MultipleChoiceQuestion__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2912:1: ( ( 'end' ) )
            // InternalQuizDSL.g:2913:1: ( 'end' )
            {
            // InternalQuizDSL.g:2913:1: ( 'end' )
            // InternalQuizDSL.g:2914:2: 'end'
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getEndKeyword_7()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getEndKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group__7__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group_4__0"
    // InternalQuizDSL.g:2924:1: rule__MultipleChoiceQuestion__Group_4__0 : rule__MultipleChoiceQuestion__Group_4__0__Impl rule__MultipleChoiceQuestion__Group_4__1 ;
    public final void rule__MultipleChoiceQuestion__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2928:1: ( rule__MultipleChoiceQuestion__Group_4__0__Impl rule__MultipleChoiceQuestion__Group_4__1 )
            // InternalQuizDSL.g:2929:2: rule__MultipleChoiceQuestion__Group_4__0__Impl rule__MultipleChoiceQuestion__Group_4__1
            {
            pushFollow(FOLLOW_29);
            rule__MultipleChoiceQuestion__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group_4__0"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group_4__0__Impl"
    // InternalQuizDSL.g:2936:1: rule__MultipleChoiceQuestion__Group_4__0__Impl : ( 'val' ) ;
    public final void rule__MultipleChoiceQuestion__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2940:1: ( ( 'val' ) )
            // InternalQuizDSL.g:2941:1: ( 'val' )
            {
            // InternalQuizDSL.g:2941:1: ( 'val' )
            // InternalQuizDSL.g:2942:2: 'val'
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getValKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getValKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group_4__0__Impl"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group_4__1"
    // InternalQuizDSL.g:2951:1: rule__MultipleChoiceQuestion__Group_4__1 : rule__MultipleChoiceQuestion__Group_4__1__Impl ;
    public final void rule__MultipleChoiceQuestion__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2955:1: ( rule__MultipleChoiceQuestion__Group_4__1__Impl )
            // InternalQuizDSL.g:2956:2: rule__MultipleChoiceQuestion__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group_4__1"


    // $ANTLR start "rule__MultipleChoiceQuestion__Group_4__1__Impl"
    // InternalQuizDSL.g:2962:1: rule__MultipleChoiceQuestion__Group_4__1__Impl : ( ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 ) ) ;
    public final void rule__MultipleChoiceQuestion__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2966:1: ( ( ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 ) ) )
            // InternalQuizDSL.g:2967:1: ( ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 ) )
            {
            // InternalQuizDSL.g:2967:1: ( ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 ) )
            // InternalQuizDSL.g:2968:2: ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 )
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getScoreAssignment_4_1()); 
            // InternalQuizDSL.g:2969:2: ( rule__MultipleChoiceQuestion__ScoreAssignment_4_1 )
            // InternalQuizDSL.g:2969:3: rule__MultipleChoiceQuestion__ScoreAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__MultipleChoiceQuestion__ScoreAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMultipleChoiceQuestionAccess().getScoreAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__Group_4__1__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__0"
    // InternalQuizDSL.g:2978:1: rule__TrueFalseQuestion__Group__0 : rule__TrueFalseQuestion__Group__0__Impl rule__TrueFalseQuestion__Group__1 ;
    public final void rule__TrueFalseQuestion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2982:1: ( rule__TrueFalseQuestion__Group__0__Impl rule__TrueFalseQuestion__Group__1 )
            // InternalQuizDSL.g:2983:2: rule__TrueFalseQuestion__Group__0__Impl rule__TrueFalseQuestion__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__TrueFalseQuestion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__0"


    // $ANTLR start "rule__TrueFalseQuestion__Group__0__Impl"
    // InternalQuizDSL.g:2990:1: rule__TrueFalseQuestion__Group__0__Impl : ( 'true_false' ) ;
    public final void rule__TrueFalseQuestion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:2994:1: ( ( 'true_false' ) )
            // InternalQuizDSL.g:2995:1: ( 'true_false' )
            {
            // InternalQuizDSL.g:2995:1: ( 'true_false' )
            // InternalQuizDSL.g:2996:2: 'true_false'
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getTrue_falseKeyword_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getTrue_falseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__0__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__1"
    // InternalQuizDSL.g:3005:1: rule__TrueFalseQuestion__Group__1 : rule__TrueFalseQuestion__Group__1__Impl rule__TrueFalseQuestion__Group__2 ;
    public final void rule__TrueFalseQuestion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3009:1: ( rule__TrueFalseQuestion__Group__1__Impl rule__TrueFalseQuestion__Group__2 )
            // InternalQuizDSL.g:3010:2: rule__TrueFalseQuestion__Group__1__Impl rule__TrueFalseQuestion__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__TrueFalseQuestion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__1"


    // $ANTLR start "rule__TrueFalseQuestion__Group__1__Impl"
    // InternalQuizDSL.g:3017:1: rule__TrueFalseQuestion__Group__1__Impl : ( ( rule__TrueFalseQuestion__NameAssignment_1 ) ) ;
    public final void rule__TrueFalseQuestion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3021:1: ( ( ( rule__TrueFalseQuestion__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:3022:1: ( ( rule__TrueFalseQuestion__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:3022:1: ( ( rule__TrueFalseQuestion__NameAssignment_1 ) )
            // InternalQuizDSL.g:3023:2: ( rule__TrueFalseQuestion__NameAssignment_1 )
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:3024:2: ( rule__TrueFalseQuestion__NameAssignment_1 )
            // InternalQuizDSL.g:3024:3: rule__TrueFalseQuestion__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrueFalseQuestionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__1__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__2"
    // InternalQuizDSL.g:3032:1: rule__TrueFalseQuestion__Group__2 : rule__TrueFalseQuestion__Group__2__Impl rule__TrueFalseQuestion__Group__3 ;
    public final void rule__TrueFalseQuestion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3036:1: ( rule__TrueFalseQuestion__Group__2__Impl rule__TrueFalseQuestion__Group__3 )
            // InternalQuizDSL.g:3037:2: rule__TrueFalseQuestion__Group__2__Impl rule__TrueFalseQuestion__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__TrueFalseQuestion__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__2"


    // $ANTLR start "rule__TrueFalseQuestion__Group__2__Impl"
    // InternalQuizDSL.g:3044:1: rule__TrueFalseQuestion__Group__2__Impl : ( 'text' ) ;
    public final void rule__TrueFalseQuestion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3048:1: ( ( 'text' ) )
            // InternalQuizDSL.g:3049:1: ( 'text' )
            {
            // InternalQuizDSL.g:3049:1: ( 'text' )
            // InternalQuizDSL.g:3050:2: 'text'
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getTextKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__2__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__3"
    // InternalQuizDSL.g:3059:1: rule__TrueFalseQuestion__Group__3 : rule__TrueFalseQuestion__Group__3__Impl rule__TrueFalseQuestion__Group__4 ;
    public final void rule__TrueFalseQuestion__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3063:1: ( rule__TrueFalseQuestion__Group__3__Impl rule__TrueFalseQuestion__Group__4 )
            // InternalQuizDSL.g:3064:2: rule__TrueFalseQuestion__Group__3__Impl rule__TrueFalseQuestion__Group__4
            {
            pushFollow(FOLLOW_35);
            rule__TrueFalseQuestion__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__3"


    // $ANTLR start "rule__TrueFalseQuestion__Group__3__Impl"
    // InternalQuizDSL.g:3071:1: rule__TrueFalseQuestion__Group__3__Impl : ( ( rule__TrueFalseQuestion__TextAssignment_3 ) ) ;
    public final void rule__TrueFalseQuestion__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3075:1: ( ( ( rule__TrueFalseQuestion__TextAssignment_3 ) ) )
            // InternalQuizDSL.g:3076:1: ( ( rule__TrueFalseQuestion__TextAssignment_3 ) )
            {
            // InternalQuizDSL.g:3076:1: ( ( rule__TrueFalseQuestion__TextAssignment_3 ) )
            // InternalQuizDSL.g:3077:2: ( rule__TrueFalseQuestion__TextAssignment_3 )
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getTextAssignment_3()); 
            // InternalQuizDSL.g:3078:2: ( rule__TrueFalseQuestion__TextAssignment_3 )
            // InternalQuizDSL.g:3078:3: rule__TrueFalseQuestion__TextAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__TextAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTrueFalseQuestionAccess().getTextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__3__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__4"
    // InternalQuizDSL.g:3086:1: rule__TrueFalseQuestion__Group__4 : rule__TrueFalseQuestion__Group__4__Impl rule__TrueFalseQuestion__Group__5 ;
    public final void rule__TrueFalseQuestion__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3090:1: ( rule__TrueFalseQuestion__Group__4__Impl rule__TrueFalseQuestion__Group__5 )
            // InternalQuizDSL.g:3091:2: rule__TrueFalseQuestion__Group__4__Impl rule__TrueFalseQuestion__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__TrueFalseQuestion__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__4"


    // $ANTLR start "rule__TrueFalseQuestion__Group__4__Impl"
    // InternalQuizDSL.g:3098:1: rule__TrueFalseQuestion__Group__4__Impl : ( ( rule__TrueFalseQuestion__Group_4__0 )? ) ;
    public final void rule__TrueFalseQuestion__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3102:1: ( ( ( rule__TrueFalseQuestion__Group_4__0 )? ) )
            // InternalQuizDSL.g:3103:1: ( ( rule__TrueFalseQuestion__Group_4__0 )? )
            {
            // InternalQuizDSL.g:3103:1: ( ( rule__TrueFalseQuestion__Group_4__0 )? )
            // InternalQuizDSL.g:3104:2: ( rule__TrueFalseQuestion__Group_4__0 )?
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getGroup_4()); 
            // InternalQuizDSL.g:3105:2: ( rule__TrueFalseQuestion__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==44) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalQuizDSL.g:3105:3: rule__TrueFalseQuestion__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrueFalseQuestion__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrueFalseQuestionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__4__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__5"
    // InternalQuizDSL.g:3113:1: rule__TrueFalseQuestion__Group__5 : rule__TrueFalseQuestion__Group__5__Impl rule__TrueFalseQuestion__Group__6 ;
    public final void rule__TrueFalseQuestion__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3117:1: ( rule__TrueFalseQuestion__Group__5__Impl rule__TrueFalseQuestion__Group__6 )
            // InternalQuizDSL.g:3118:2: rule__TrueFalseQuestion__Group__5__Impl rule__TrueFalseQuestion__Group__6
            {
            pushFollow(FOLLOW_36);
            rule__TrueFalseQuestion__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__5"


    // $ANTLR start "rule__TrueFalseQuestion__Group__5__Impl"
    // InternalQuizDSL.g:3125:1: rule__TrueFalseQuestion__Group__5__Impl : ( 'answer' ) ;
    public final void rule__TrueFalseQuestion__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3129:1: ( ( 'answer' ) )
            // InternalQuizDSL.g:3130:1: ( 'answer' )
            {
            // InternalQuizDSL.g:3130:1: ( 'answer' )
            // InternalQuizDSL.g:3131:2: 'answer'
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getAnswerKeyword_5()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getAnswerKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__5__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__6"
    // InternalQuizDSL.g:3140:1: rule__TrueFalseQuestion__Group__6 : rule__TrueFalseQuestion__Group__6__Impl rule__TrueFalseQuestion__Group__7 ;
    public final void rule__TrueFalseQuestion__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3144:1: ( rule__TrueFalseQuestion__Group__6__Impl rule__TrueFalseQuestion__Group__7 )
            // InternalQuizDSL.g:3145:2: rule__TrueFalseQuestion__Group__6__Impl rule__TrueFalseQuestion__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__TrueFalseQuestion__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__6"


    // $ANTLR start "rule__TrueFalseQuestion__Group__6__Impl"
    // InternalQuizDSL.g:3152:1: rule__TrueFalseQuestion__Group__6__Impl : ( ( rule__TrueFalseQuestion__IsTrueAssignment_6 ) ) ;
    public final void rule__TrueFalseQuestion__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3156:1: ( ( ( rule__TrueFalseQuestion__IsTrueAssignment_6 ) ) )
            // InternalQuizDSL.g:3157:1: ( ( rule__TrueFalseQuestion__IsTrueAssignment_6 ) )
            {
            // InternalQuizDSL.g:3157:1: ( ( rule__TrueFalseQuestion__IsTrueAssignment_6 ) )
            // InternalQuizDSL.g:3158:2: ( rule__TrueFalseQuestion__IsTrueAssignment_6 )
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getIsTrueAssignment_6()); 
            // InternalQuizDSL.g:3159:2: ( rule__TrueFalseQuestion__IsTrueAssignment_6 )
            // InternalQuizDSL.g:3159:3: rule__TrueFalseQuestion__IsTrueAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__IsTrueAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTrueFalseQuestionAccess().getIsTrueAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__6__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group__7"
    // InternalQuizDSL.g:3167:1: rule__TrueFalseQuestion__Group__7 : rule__TrueFalseQuestion__Group__7__Impl ;
    public final void rule__TrueFalseQuestion__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3171:1: ( rule__TrueFalseQuestion__Group__7__Impl )
            // InternalQuizDSL.g:3172:2: rule__TrueFalseQuestion__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__7"


    // $ANTLR start "rule__TrueFalseQuestion__Group__7__Impl"
    // InternalQuizDSL.g:3178:1: rule__TrueFalseQuestion__Group__7__Impl : ( 'end' ) ;
    public final void rule__TrueFalseQuestion__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3182:1: ( ( 'end' ) )
            // InternalQuizDSL.g:3183:1: ( 'end' )
            {
            // InternalQuizDSL.g:3183:1: ( 'end' )
            // InternalQuizDSL.g:3184:2: 'end'
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getEndKeyword_7()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getEndKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group__7__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group_4__0"
    // InternalQuizDSL.g:3194:1: rule__TrueFalseQuestion__Group_4__0 : rule__TrueFalseQuestion__Group_4__0__Impl rule__TrueFalseQuestion__Group_4__1 ;
    public final void rule__TrueFalseQuestion__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3198:1: ( rule__TrueFalseQuestion__Group_4__0__Impl rule__TrueFalseQuestion__Group_4__1 )
            // InternalQuizDSL.g:3199:2: rule__TrueFalseQuestion__Group_4__0__Impl rule__TrueFalseQuestion__Group_4__1
            {
            pushFollow(FOLLOW_29);
            rule__TrueFalseQuestion__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group_4__0"


    // $ANTLR start "rule__TrueFalseQuestion__Group_4__0__Impl"
    // InternalQuizDSL.g:3206:1: rule__TrueFalseQuestion__Group_4__0__Impl : ( 'val' ) ;
    public final void rule__TrueFalseQuestion__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3210:1: ( ( 'val' ) )
            // InternalQuizDSL.g:3211:1: ( 'val' )
            {
            // InternalQuizDSL.g:3211:1: ( 'val' )
            // InternalQuizDSL.g:3212:2: 'val'
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getValKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getValKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group_4__0__Impl"


    // $ANTLR start "rule__TrueFalseQuestion__Group_4__1"
    // InternalQuizDSL.g:3221:1: rule__TrueFalseQuestion__Group_4__1 : rule__TrueFalseQuestion__Group_4__1__Impl ;
    public final void rule__TrueFalseQuestion__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3225:1: ( rule__TrueFalseQuestion__Group_4__1__Impl )
            // InternalQuizDSL.g:3226:2: rule__TrueFalseQuestion__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group_4__1"


    // $ANTLR start "rule__TrueFalseQuestion__Group_4__1__Impl"
    // InternalQuizDSL.g:3232:1: rule__TrueFalseQuestion__Group_4__1__Impl : ( ( rule__TrueFalseQuestion__ScoreAssignment_4_1 ) ) ;
    public final void rule__TrueFalseQuestion__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3236:1: ( ( ( rule__TrueFalseQuestion__ScoreAssignment_4_1 ) ) )
            // InternalQuizDSL.g:3237:1: ( ( rule__TrueFalseQuestion__ScoreAssignment_4_1 ) )
            {
            // InternalQuizDSL.g:3237:1: ( ( rule__TrueFalseQuestion__ScoreAssignment_4_1 ) )
            // InternalQuizDSL.g:3238:2: ( rule__TrueFalseQuestion__ScoreAssignment_4_1 )
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getScoreAssignment_4_1()); 
            // InternalQuizDSL.g:3239:2: ( rule__TrueFalseQuestion__ScoreAssignment_4_1 )
            // InternalQuizDSL.g:3239:3: rule__TrueFalseQuestion__ScoreAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TrueFalseQuestion__ScoreAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTrueFalseQuestionAccess().getScoreAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__Group_4__1__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__0"
    // InternalQuizDSL.g:3248:1: rule__DescriptiveQuestion__Group__0 : rule__DescriptiveQuestion__Group__0__Impl rule__DescriptiveQuestion__Group__1 ;
    public final void rule__DescriptiveQuestion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3252:1: ( rule__DescriptiveQuestion__Group__0__Impl rule__DescriptiveQuestion__Group__1 )
            // InternalQuizDSL.g:3253:2: rule__DescriptiveQuestion__Group__0__Impl rule__DescriptiveQuestion__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__DescriptiveQuestion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__0"


    // $ANTLR start "rule__DescriptiveQuestion__Group__0__Impl"
    // InternalQuizDSL.g:3260:1: rule__DescriptiveQuestion__Group__0__Impl : ( 'descriptive' ) ;
    public final void rule__DescriptiveQuestion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3264:1: ( ( 'descriptive' ) )
            // InternalQuizDSL.g:3265:1: ( 'descriptive' )
            {
            // InternalQuizDSL.g:3265:1: ( 'descriptive' )
            // InternalQuizDSL.g:3266:2: 'descriptive'
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getDescriptiveKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getDescriptiveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__0__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__1"
    // InternalQuizDSL.g:3275:1: rule__DescriptiveQuestion__Group__1 : rule__DescriptiveQuestion__Group__1__Impl rule__DescriptiveQuestion__Group__2 ;
    public final void rule__DescriptiveQuestion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3279:1: ( rule__DescriptiveQuestion__Group__1__Impl rule__DescriptiveQuestion__Group__2 )
            // InternalQuizDSL.g:3280:2: rule__DescriptiveQuestion__Group__1__Impl rule__DescriptiveQuestion__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__DescriptiveQuestion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__1"


    // $ANTLR start "rule__DescriptiveQuestion__Group__1__Impl"
    // InternalQuizDSL.g:3287:1: rule__DescriptiveQuestion__Group__1__Impl : ( ( rule__DescriptiveQuestion__NameAssignment_1 ) ) ;
    public final void rule__DescriptiveQuestion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3291:1: ( ( ( rule__DescriptiveQuestion__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:3292:1: ( ( rule__DescriptiveQuestion__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:3292:1: ( ( rule__DescriptiveQuestion__NameAssignment_1 ) )
            // InternalQuizDSL.g:3293:2: ( rule__DescriptiveQuestion__NameAssignment_1 )
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:3294:2: ( rule__DescriptiveQuestion__NameAssignment_1 )
            // InternalQuizDSL.g:3294:3: rule__DescriptiveQuestion__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDescriptiveQuestionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__1__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__2"
    // InternalQuizDSL.g:3302:1: rule__DescriptiveQuestion__Group__2 : rule__DescriptiveQuestion__Group__2__Impl rule__DescriptiveQuestion__Group__3 ;
    public final void rule__DescriptiveQuestion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3306:1: ( rule__DescriptiveQuestion__Group__2__Impl rule__DescriptiveQuestion__Group__3 )
            // InternalQuizDSL.g:3307:2: rule__DescriptiveQuestion__Group__2__Impl rule__DescriptiveQuestion__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__DescriptiveQuestion__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__2"


    // $ANTLR start "rule__DescriptiveQuestion__Group__2__Impl"
    // InternalQuizDSL.g:3314:1: rule__DescriptiveQuestion__Group__2__Impl : ( 'text' ) ;
    public final void rule__DescriptiveQuestion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3318:1: ( ( 'text' ) )
            // InternalQuizDSL.g:3319:1: ( 'text' )
            {
            // InternalQuizDSL.g:3319:1: ( 'text' )
            // InternalQuizDSL.g:3320:2: 'text'
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getTextKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__2__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__3"
    // InternalQuizDSL.g:3329:1: rule__DescriptiveQuestion__Group__3 : rule__DescriptiveQuestion__Group__3__Impl rule__DescriptiveQuestion__Group__4 ;
    public final void rule__DescriptiveQuestion__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3333:1: ( rule__DescriptiveQuestion__Group__3__Impl rule__DescriptiveQuestion__Group__4 )
            // InternalQuizDSL.g:3334:2: rule__DescriptiveQuestion__Group__3__Impl rule__DescriptiveQuestion__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__DescriptiveQuestion__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__3"


    // $ANTLR start "rule__DescriptiveQuestion__Group__3__Impl"
    // InternalQuizDSL.g:3341:1: rule__DescriptiveQuestion__Group__3__Impl : ( ( rule__DescriptiveQuestion__TextAssignment_3 ) ) ;
    public final void rule__DescriptiveQuestion__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3345:1: ( ( ( rule__DescriptiveQuestion__TextAssignment_3 ) ) )
            // InternalQuizDSL.g:3346:1: ( ( rule__DescriptiveQuestion__TextAssignment_3 ) )
            {
            // InternalQuizDSL.g:3346:1: ( ( rule__DescriptiveQuestion__TextAssignment_3 ) )
            // InternalQuizDSL.g:3347:2: ( rule__DescriptiveQuestion__TextAssignment_3 )
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getTextAssignment_3()); 
            // InternalQuizDSL.g:3348:2: ( rule__DescriptiveQuestion__TextAssignment_3 )
            // InternalQuizDSL.g:3348:3: rule__DescriptiveQuestion__TextAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__TextAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDescriptiveQuestionAccess().getTextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__3__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__4"
    // InternalQuizDSL.g:3356:1: rule__DescriptiveQuestion__Group__4 : rule__DescriptiveQuestion__Group__4__Impl rule__DescriptiveQuestion__Group__5 ;
    public final void rule__DescriptiveQuestion__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3360:1: ( rule__DescriptiveQuestion__Group__4__Impl rule__DescriptiveQuestion__Group__5 )
            // InternalQuizDSL.g:3361:2: rule__DescriptiveQuestion__Group__4__Impl rule__DescriptiveQuestion__Group__5
            {
            pushFollow(FOLLOW_37);
            rule__DescriptiveQuestion__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__4"


    // $ANTLR start "rule__DescriptiveQuestion__Group__4__Impl"
    // InternalQuizDSL.g:3368:1: rule__DescriptiveQuestion__Group__4__Impl : ( ( rule__DescriptiveQuestion__Group_4__0 )? ) ;
    public final void rule__DescriptiveQuestion__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3372:1: ( ( ( rule__DescriptiveQuestion__Group_4__0 )? ) )
            // InternalQuizDSL.g:3373:1: ( ( rule__DescriptiveQuestion__Group_4__0 )? )
            {
            // InternalQuizDSL.g:3373:1: ( ( rule__DescriptiveQuestion__Group_4__0 )? )
            // InternalQuizDSL.g:3374:2: ( rule__DescriptiveQuestion__Group_4__0 )?
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getGroup_4()); 
            // InternalQuizDSL.g:3375:2: ( rule__DescriptiveQuestion__Group_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==44) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalQuizDSL.g:3375:3: rule__DescriptiveQuestion__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DescriptiveQuestion__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDescriptiveQuestionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__4__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group__5"
    // InternalQuizDSL.g:3383:1: rule__DescriptiveQuestion__Group__5 : rule__DescriptiveQuestion__Group__5__Impl ;
    public final void rule__DescriptiveQuestion__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3387:1: ( rule__DescriptiveQuestion__Group__5__Impl )
            // InternalQuizDSL.g:3388:2: rule__DescriptiveQuestion__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__5"


    // $ANTLR start "rule__DescriptiveQuestion__Group__5__Impl"
    // InternalQuizDSL.g:3394:1: rule__DescriptiveQuestion__Group__5__Impl : ( 'end' ) ;
    public final void rule__DescriptiveQuestion__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3398:1: ( ( 'end' ) )
            // InternalQuizDSL.g:3399:1: ( 'end' )
            {
            // InternalQuizDSL.g:3399:1: ( 'end' )
            // InternalQuizDSL.g:3400:2: 'end'
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getEndKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group__5__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group_4__0"
    // InternalQuizDSL.g:3410:1: rule__DescriptiveQuestion__Group_4__0 : rule__DescriptiveQuestion__Group_4__0__Impl rule__DescriptiveQuestion__Group_4__1 ;
    public final void rule__DescriptiveQuestion__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3414:1: ( rule__DescriptiveQuestion__Group_4__0__Impl rule__DescriptiveQuestion__Group_4__1 )
            // InternalQuizDSL.g:3415:2: rule__DescriptiveQuestion__Group_4__0__Impl rule__DescriptiveQuestion__Group_4__1
            {
            pushFollow(FOLLOW_29);
            rule__DescriptiveQuestion__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group_4__0"


    // $ANTLR start "rule__DescriptiveQuestion__Group_4__0__Impl"
    // InternalQuizDSL.g:3422:1: rule__DescriptiveQuestion__Group_4__0__Impl : ( 'val' ) ;
    public final void rule__DescriptiveQuestion__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3426:1: ( ( 'val' ) )
            // InternalQuizDSL.g:3427:1: ( 'val' )
            {
            // InternalQuizDSL.g:3427:1: ( 'val' )
            // InternalQuizDSL.g:3428:2: 'val'
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getValKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getValKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group_4__0__Impl"


    // $ANTLR start "rule__DescriptiveQuestion__Group_4__1"
    // InternalQuizDSL.g:3437:1: rule__DescriptiveQuestion__Group_4__1 : rule__DescriptiveQuestion__Group_4__1__Impl ;
    public final void rule__DescriptiveQuestion__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3441:1: ( rule__DescriptiveQuestion__Group_4__1__Impl )
            // InternalQuizDSL.g:3442:2: rule__DescriptiveQuestion__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group_4__1"


    // $ANTLR start "rule__DescriptiveQuestion__Group_4__1__Impl"
    // InternalQuizDSL.g:3448:1: rule__DescriptiveQuestion__Group_4__1__Impl : ( ( rule__DescriptiveQuestion__ScoreAssignment_4_1 ) ) ;
    public final void rule__DescriptiveQuestion__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3452:1: ( ( ( rule__DescriptiveQuestion__ScoreAssignment_4_1 ) ) )
            // InternalQuizDSL.g:3453:1: ( ( rule__DescriptiveQuestion__ScoreAssignment_4_1 ) )
            {
            // InternalQuizDSL.g:3453:1: ( ( rule__DescriptiveQuestion__ScoreAssignment_4_1 ) )
            // InternalQuizDSL.g:3454:2: ( rule__DescriptiveQuestion__ScoreAssignment_4_1 )
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getScoreAssignment_4_1()); 
            // InternalQuizDSL.g:3455:2: ( rule__DescriptiveQuestion__ScoreAssignment_4_1 )
            // InternalQuizDSL.g:3455:3: rule__DescriptiveQuestion__ScoreAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DescriptiveQuestion__ScoreAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDescriptiveQuestionAccess().getScoreAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__Group_4__1__Impl"


    // $ANTLR start "rule__Option__Group__0"
    // InternalQuizDSL.g:3464:1: rule__Option__Group__0 : rule__Option__Group__0__Impl rule__Option__Group__1 ;
    public final void rule__Option__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3468:1: ( rule__Option__Group__0__Impl rule__Option__Group__1 )
            // InternalQuizDSL.g:3469:2: rule__Option__Group__0__Impl rule__Option__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__Option__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__0"


    // $ANTLR start "rule__Option__Group__0__Impl"
    // InternalQuizDSL.g:3476:1: rule__Option__Group__0__Impl : ( ( rule__Option__NameAssignment_0 ) ) ;
    public final void rule__Option__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3480:1: ( ( ( rule__Option__NameAssignment_0 ) ) )
            // InternalQuizDSL.g:3481:1: ( ( rule__Option__NameAssignment_0 ) )
            {
            // InternalQuizDSL.g:3481:1: ( ( rule__Option__NameAssignment_0 ) )
            // InternalQuizDSL.g:3482:2: ( rule__Option__NameAssignment_0 )
            {
             before(grammarAccess.getOptionAccess().getNameAssignment_0()); 
            // InternalQuizDSL.g:3483:2: ( rule__Option__NameAssignment_0 )
            // InternalQuizDSL.g:3483:3: rule__Option__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Option__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__0__Impl"


    // $ANTLR start "rule__Option__Group__1"
    // InternalQuizDSL.g:3491:1: rule__Option__Group__1 : rule__Option__Group__1__Impl rule__Option__Group__2 ;
    public final void rule__Option__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3495:1: ( rule__Option__Group__1__Impl rule__Option__Group__2 )
            // InternalQuizDSL.g:3496:2: rule__Option__Group__1__Impl rule__Option__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Option__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__1"


    // $ANTLR start "rule__Option__Group__1__Impl"
    // InternalQuizDSL.g:3503:1: rule__Option__Group__1__Impl : ( '->' ) ;
    public final void rule__Option__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3507:1: ( ( '->' ) )
            // InternalQuizDSL.g:3508:1: ( '->' )
            {
            // InternalQuizDSL.g:3508:1: ( '->' )
            // InternalQuizDSL.g:3509:2: '->'
            {
             before(grammarAccess.getOptionAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__1__Impl"


    // $ANTLR start "rule__Option__Group__2"
    // InternalQuizDSL.g:3518:1: rule__Option__Group__2 : rule__Option__Group__2__Impl ;
    public final void rule__Option__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3522:1: ( rule__Option__Group__2__Impl )
            // InternalQuizDSL.g:3523:2: rule__Option__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Option__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__2"


    // $ANTLR start "rule__Option__Group__2__Impl"
    // InternalQuizDSL.g:3529:1: rule__Option__Group__2__Impl : ( ( rule__Option__TextAssignment_2 ) ) ;
    public final void rule__Option__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3533:1: ( ( ( rule__Option__TextAssignment_2 ) ) )
            // InternalQuizDSL.g:3534:1: ( ( rule__Option__TextAssignment_2 ) )
            {
            // InternalQuizDSL.g:3534:1: ( ( rule__Option__TextAssignment_2 ) )
            // InternalQuizDSL.g:3535:2: ( rule__Option__TextAssignment_2 )
            {
             before(grammarAccess.getOptionAccess().getTextAssignment_2()); 
            // InternalQuizDSL.g:3536:2: ( rule__Option__TextAssignment_2 )
            // InternalQuizDSL.g:3536:3: rule__Option__TextAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Option__TextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getTextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__2__Impl"


    // $ANTLR start "rule__QuizResult__Group__0"
    // InternalQuizDSL.g:3545:1: rule__QuizResult__Group__0 : rule__QuizResult__Group__0__Impl rule__QuizResult__Group__1 ;
    public final void rule__QuizResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3549:1: ( rule__QuizResult__Group__0__Impl rule__QuizResult__Group__1 )
            // InternalQuizDSL.g:3550:2: rule__QuizResult__Group__0__Impl rule__QuizResult__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__QuizResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__0"


    // $ANTLR start "rule__QuizResult__Group__0__Impl"
    // InternalQuizDSL.g:3557:1: rule__QuizResult__Group__0__Impl : ( 'result' ) ;
    public final void rule__QuizResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3561:1: ( ( 'result' ) )
            // InternalQuizDSL.g:3562:1: ( 'result' )
            {
            // InternalQuizDSL.g:3562:1: ( 'result' )
            // InternalQuizDSL.g:3563:2: 'result'
            {
             before(grammarAccess.getQuizResultAccess().getResultKeyword_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getResultKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__0__Impl"


    // $ANTLR start "rule__QuizResult__Group__1"
    // InternalQuizDSL.g:3572:1: rule__QuizResult__Group__1 : rule__QuizResult__Group__1__Impl rule__QuizResult__Group__2 ;
    public final void rule__QuizResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3576:1: ( rule__QuizResult__Group__1__Impl rule__QuizResult__Group__2 )
            // InternalQuizDSL.g:3577:2: rule__QuizResult__Group__1__Impl rule__QuizResult__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__QuizResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__1"


    // $ANTLR start "rule__QuizResult__Group__1__Impl"
    // InternalQuizDSL.g:3584:1: rule__QuizResult__Group__1__Impl : ( ( rule__QuizResult__NameAssignment_1 ) ) ;
    public final void rule__QuizResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3588:1: ( ( ( rule__QuizResult__NameAssignment_1 ) ) )
            // InternalQuizDSL.g:3589:1: ( ( rule__QuizResult__NameAssignment_1 ) )
            {
            // InternalQuizDSL.g:3589:1: ( ( rule__QuizResult__NameAssignment_1 ) )
            // InternalQuizDSL.g:3590:2: ( rule__QuizResult__NameAssignment_1 )
            {
             before(grammarAccess.getQuizResultAccess().getNameAssignment_1()); 
            // InternalQuizDSL.g:3591:2: ( rule__QuizResult__NameAssignment_1 )
            // InternalQuizDSL.g:3591:3: rule__QuizResult__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__1__Impl"


    // $ANTLR start "rule__QuizResult__Group__2"
    // InternalQuizDSL.g:3599:1: rule__QuizResult__Group__2 : rule__QuizResult__Group__2__Impl rule__QuizResult__Group__3 ;
    public final void rule__QuizResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3603:1: ( rule__QuizResult__Group__2__Impl rule__QuizResult__Group__3 )
            // InternalQuizDSL.g:3604:2: rule__QuizResult__Group__2__Impl rule__QuizResult__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__QuizResult__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__2"


    // $ANTLR start "rule__QuizResult__Group__2__Impl"
    // InternalQuizDSL.g:3611:1: rule__QuizResult__Group__2__Impl : ( 'user' ) ;
    public final void rule__QuizResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3615:1: ( ( 'user' ) )
            // InternalQuizDSL.g:3616:1: ( 'user' )
            {
            // InternalQuizDSL.g:3616:1: ( 'user' )
            // InternalQuizDSL.g:3617:2: 'user'
            {
             before(grammarAccess.getQuizResultAccess().getUserKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getUserKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__2__Impl"


    // $ANTLR start "rule__QuizResult__Group__3"
    // InternalQuizDSL.g:3626:1: rule__QuizResult__Group__3 : rule__QuizResult__Group__3__Impl rule__QuizResult__Group__4 ;
    public final void rule__QuizResult__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3630:1: ( rule__QuizResult__Group__3__Impl rule__QuizResult__Group__4 )
            // InternalQuizDSL.g:3631:2: rule__QuizResult__Group__3__Impl rule__QuizResult__Group__4
            {
            pushFollow(FOLLOW_40);
            rule__QuizResult__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__3"


    // $ANTLR start "rule__QuizResult__Group__3__Impl"
    // InternalQuizDSL.g:3638:1: rule__QuizResult__Group__3__Impl : ( ( rule__QuizResult__UserAssignment_3 ) ) ;
    public final void rule__QuizResult__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3642:1: ( ( ( rule__QuizResult__UserAssignment_3 ) ) )
            // InternalQuizDSL.g:3643:1: ( ( rule__QuizResult__UserAssignment_3 ) )
            {
            // InternalQuizDSL.g:3643:1: ( ( rule__QuizResult__UserAssignment_3 ) )
            // InternalQuizDSL.g:3644:2: ( rule__QuizResult__UserAssignment_3 )
            {
             before(grammarAccess.getQuizResultAccess().getUserAssignment_3()); 
            // InternalQuizDSL.g:3645:2: ( rule__QuizResult__UserAssignment_3 )
            // InternalQuizDSL.g:3645:3: rule__QuizResult__UserAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__UserAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getUserAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__3__Impl"


    // $ANTLR start "rule__QuizResult__Group__4"
    // InternalQuizDSL.g:3653:1: rule__QuizResult__Group__4 : rule__QuizResult__Group__4__Impl rule__QuizResult__Group__5 ;
    public final void rule__QuizResult__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3657:1: ( rule__QuizResult__Group__4__Impl rule__QuizResult__Group__5 )
            // InternalQuizDSL.g:3658:2: rule__QuizResult__Group__4__Impl rule__QuizResult__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__QuizResult__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__4"


    // $ANTLR start "rule__QuizResult__Group__4__Impl"
    // InternalQuizDSL.g:3665:1: rule__QuizResult__Group__4__Impl : ( 'quiz' ) ;
    public final void rule__QuizResult__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3669:1: ( ( 'quiz' ) )
            // InternalQuizDSL.g:3670:1: ( 'quiz' )
            {
            // InternalQuizDSL.g:3670:1: ( 'quiz' )
            // InternalQuizDSL.g:3671:2: 'quiz'
            {
             before(grammarAccess.getQuizResultAccess().getQuizKeyword_4()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getQuizKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__4__Impl"


    // $ANTLR start "rule__QuizResult__Group__5"
    // InternalQuizDSL.g:3680:1: rule__QuizResult__Group__5 : rule__QuizResult__Group__5__Impl rule__QuizResult__Group__6 ;
    public final void rule__QuizResult__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3684:1: ( rule__QuizResult__Group__5__Impl rule__QuizResult__Group__6 )
            // InternalQuizDSL.g:3685:2: rule__QuizResult__Group__5__Impl rule__QuizResult__Group__6
            {
            pushFollow(FOLLOW_41);
            rule__QuizResult__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__5"


    // $ANTLR start "rule__QuizResult__Group__5__Impl"
    // InternalQuizDSL.g:3692:1: rule__QuizResult__Group__5__Impl : ( ( rule__QuizResult__QuizAssignment_5 ) ) ;
    public final void rule__QuizResult__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3696:1: ( ( ( rule__QuizResult__QuizAssignment_5 ) ) )
            // InternalQuizDSL.g:3697:1: ( ( rule__QuizResult__QuizAssignment_5 ) )
            {
            // InternalQuizDSL.g:3697:1: ( ( rule__QuizResult__QuizAssignment_5 ) )
            // InternalQuizDSL.g:3698:2: ( rule__QuizResult__QuizAssignment_5 )
            {
             before(grammarAccess.getQuizResultAccess().getQuizAssignment_5()); 
            // InternalQuizDSL.g:3699:2: ( rule__QuizResult__QuizAssignment_5 )
            // InternalQuizDSL.g:3699:3: rule__QuizResult__QuizAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__QuizAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getQuizAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__5__Impl"


    // $ANTLR start "rule__QuizResult__Group__6"
    // InternalQuizDSL.g:3707:1: rule__QuizResult__Group__6 : rule__QuizResult__Group__6__Impl rule__QuizResult__Group__7 ;
    public final void rule__QuizResult__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3711:1: ( rule__QuizResult__Group__6__Impl rule__QuizResult__Group__7 )
            // InternalQuizDSL.g:3712:2: rule__QuizResult__Group__6__Impl rule__QuizResult__Group__7
            {
            pushFollow(FOLLOW_29);
            rule__QuizResult__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__6"


    // $ANTLR start "rule__QuizResult__Group__6__Impl"
    // InternalQuizDSL.g:3719:1: rule__QuizResult__Group__6__Impl : ( 'score' ) ;
    public final void rule__QuizResult__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3723:1: ( ( 'score' ) )
            // InternalQuizDSL.g:3724:1: ( 'score' )
            {
            // InternalQuizDSL.g:3724:1: ( 'score' )
            // InternalQuizDSL.g:3725:2: 'score'
            {
             before(grammarAccess.getQuizResultAccess().getScoreKeyword_6()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getScoreKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__6__Impl"


    // $ANTLR start "rule__QuizResult__Group__7"
    // InternalQuizDSL.g:3734:1: rule__QuizResult__Group__7 : rule__QuizResult__Group__7__Impl rule__QuizResult__Group__8 ;
    public final void rule__QuizResult__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3738:1: ( rule__QuizResult__Group__7__Impl rule__QuizResult__Group__8 )
            // InternalQuizDSL.g:3739:2: rule__QuizResult__Group__7__Impl rule__QuizResult__Group__8
            {
            pushFollow(FOLLOW_42);
            rule__QuizResult__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__7"


    // $ANTLR start "rule__QuizResult__Group__7__Impl"
    // InternalQuizDSL.g:3746:1: rule__QuizResult__Group__7__Impl : ( ( rule__QuizResult__FinalScoreAssignment_7 ) ) ;
    public final void rule__QuizResult__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3750:1: ( ( ( rule__QuizResult__FinalScoreAssignment_7 ) ) )
            // InternalQuizDSL.g:3751:1: ( ( rule__QuizResult__FinalScoreAssignment_7 ) )
            {
            // InternalQuizDSL.g:3751:1: ( ( rule__QuizResult__FinalScoreAssignment_7 ) )
            // InternalQuizDSL.g:3752:2: ( rule__QuizResult__FinalScoreAssignment_7 )
            {
             before(grammarAccess.getQuizResultAccess().getFinalScoreAssignment_7()); 
            // InternalQuizDSL.g:3753:2: ( rule__QuizResult__FinalScoreAssignment_7 )
            // InternalQuizDSL.g:3753:3: rule__QuizResult__FinalScoreAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__FinalScoreAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getFinalScoreAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__7__Impl"


    // $ANTLR start "rule__QuizResult__Group__8"
    // InternalQuizDSL.g:3761:1: rule__QuizResult__Group__8 : rule__QuizResult__Group__8__Impl rule__QuizResult__Group__9 ;
    public final void rule__QuizResult__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3765:1: ( rule__QuizResult__Group__8__Impl rule__QuizResult__Group__9 )
            // InternalQuizDSL.g:3766:2: rule__QuizResult__Group__8__Impl rule__QuizResult__Group__9
            {
            pushFollow(FOLLOW_43);
            rule__QuizResult__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__8"


    // $ANTLR start "rule__QuizResult__Group__8__Impl"
    // InternalQuizDSL.g:3773:1: rule__QuizResult__Group__8__Impl : ( 'responses' ) ;
    public final void rule__QuizResult__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3777:1: ( ( 'responses' ) )
            // InternalQuizDSL.g:3778:1: ( 'responses' )
            {
            // InternalQuizDSL.g:3778:1: ( 'responses' )
            // InternalQuizDSL.g:3779:2: 'responses'
            {
             before(grammarAccess.getQuizResultAccess().getResponsesKeyword_8()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getResponsesKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__8__Impl"


    // $ANTLR start "rule__QuizResult__Group__9"
    // InternalQuizDSL.g:3788:1: rule__QuizResult__Group__9 : rule__QuizResult__Group__9__Impl rule__QuizResult__Group__10 ;
    public final void rule__QuizResult__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3792:1: ( rule__QuizResult__Group__9__Impl rule__QuizResult__Group__10 )
            // InternalQuizDSL.g:3793:2: rule__QuizResult__Group__9__Impl rule__QuizResult__Group__10
            {
            pushFollow(FOLLOW_44);
            rule__QuizResult__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__9"


    // $ANTLR start "rule__QuizResult__Group__9__Impl"
    // InternalQuizDSL.g:3800:1: rule__QuizResult__Group__9__Impl : ( '{' ) ;
    public final void rule__QuizResult__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3804:1: ( ( '{' ) )
            // InternalQuizDSL.g:3805:1: ( '{' )
            {
            // InternalQuizDSL.g:3805:1: ( '{' )
            // InternalQuizDSL.g:3806:2: '{'
            {
             before(grammarAccess.getQuizResultAccess().getLeftCurlyBracketKeyword_9()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getLeftCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__9__Impl"


    // $ANTLR start "rule__QuizResult__Group__10"
    // InternalQuizDSL.g:3815:1: rule__QuizResult__Group__10 : rule__QuizResult__Group__10__Impl rule__QuizResult__Group__11 ;
    public final void rule__QuizResult__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3819:1: ( rule__QuizResult__Group__10__Impl rule__QuizResult__Group__11 )
            // InternalQuizDSL.g:3820:2: rule__QuizResult__Group__10__Impl rule__QuizResult__Group__11
            {
            pushFollow(FOLLOW_45);
            rule__QuizResult__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__10"


    // $ANTLR start "rule__QuizResult__Group__10__Impl"
    // InternalQuizDSL.g:3827:1: rule__QuizResult__Group__10__Impl : ( ( ( rule__QuizResult__ResponsesAssignment_10 ) ) ( ( rule__QuizResult__ResponsesAssignment_10 )* ) ) ;
    public final void rule__QuizResult__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3831:1: ( ( ( ( rule__QuizResult__ResponsesAssignment_10 ) ) ( ( rule__QuizResult__ResponsesAssignment_10 )* ) ) )
            // InternalQuizDSL.g:3832:1: ( ( ( rule__QuizResult__ResponsesAssignment_10 ) ) ( ( rule__QuizResult__ResponsesAssignment_10 )* ) )
            {
            // InternalQuizDSL.g:3832:1: ( ( ( rule__QuizResult__ResponsesAssignment_10 ) ) ( ( rule__QuizResult__ResponsesAssignment_10 )* ) )
            // InternalQuizDSL.g:3833:2: ( ( rule__QuizResult__ResponsesAssignment_10 ) ) ( ( rule__QuizResult__ResponsesAssignment_10 )* )
            {
            // InternalQuizDSL.g:3833:2: ( ( rule__QuizResult__ResponsesAssignment_10 ) )
            // InternalQuizDSL.g:3834:3: ( rule__QuizResult__ResponsesAssignment_10 )
            {
             before(grammarAccess.getQuizResultAccess().getResponsesAssignment_10()); 
            // InternalQuizDSL.g:3835:3: ( rule__QuizResult__ResponsesAssignment_10 )
            // InternalQuizDSL.g:3835:4: rule__QuizResult__ResponsesAssignment_10
            {
            pushFollow(FOLLOW_46);
            rule__QuizResult__ResponsesAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getQuizResultAccess().getResponsesAssignment_10()); 

            }

            // InternalQuizDSL.g:3838:2: ( ( rule__QuizResult__ResponsesAssignment_10 )* )
            // InternalQuizDSL.g:3839:3: ( rule__QuizResult__ResponsesAssignment_10 )*
            {
             before(grammarAccess.getQuizResultAccess().getResponsesAssignment_10()); 
            // InternalQuizDSL.g:3840:3: ( rule__QuizResult__ResponsesAssignment_10 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==55) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalQuizDSL.g:3840:4: rule__QuizResult__ResponsesAssignment_10
            	    {
            	    pushFollow(FOLLOW_46);
            	    rule__QuizResult__ResponsesAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getQuizResultAccess().getResponsesAssignment_10()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__10__Impl"


    // $ANTLR start "rule__QuizResult__Group__11"
    // InternalQuizDSL.g:3849:1: rule__QuizResult__Group__11 : rule__QuizResult__Group__11__Impl rule__QuizResult__Group__12 ;
    public final void rule__QuizResult__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3853:1: ( rule__QuizResult__Group__11__Impl rule__QuizResult__Group__12 )
            // InternalQuizDSL.g:3854:2: rule__QuizResult__Group__11__Impl rule__QuizResult__Group__12
            {
            pushFollow(FOLLOW_11);
            rule__QuizResult__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__11"


    // $ANTLR start "rule__QuizResult__Group__11__Impl"
    // InternalQuizDSL.g:3861:1: rule__QuizResult__Group__11__Impl : ( '}' ) ;
    public final void rule__QuizResult__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3865:1: ( ( '}' ) )
            // InternalQuizDSL.g:3866:1: ( '}' )
            {
            // InternalQuizDSL.g:3866:1: ( '}' )
            // InternalQuizDSL.g:3867:2: '}'
            {
             before(grammarAccess.getQuizResultAccess().getRightCurlyBracketKeyword_11()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__11__Impl"


    // $ANTLR start "rule__QuizResult__Group__12"
    // InternalQuizDSL.g:3876:1: rule__QuizResult__Group__12 : rule__QuizResult__Group__12__Impl ;
    public final void rule__QuizResult__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3880:1: ( rule__QuizResult__Group__12__Impl )
            // InternalQuizDSL.g:3881:2: rule__QuizResult__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuizResult__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__12"


    // $ANTLR start "rule__QuizResult__Group__12__Impl"
    // InternalQuizDSL.g:3887:1: rule__QuizResult__Group__12__Impl : ( 'end' ) ;
    public final void rule__QuizResult__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3891:1: ( ( 'end' ) )
            // InternalQuizDSL.g:3892:1: ( 'end' )
            {
            // InternalQuizDSL.g:3892:1: ( 'end' )
            // InternalQuizDSL.g:3893:2: 'end'
            {
             before(grammarAccess.getQuizResultAccess().getEndKeyword_12()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getEndKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__Group__12__Impl"


    // $ANTLR start "rule__UserResponse__Group__0"
    // InternalQuizDSL.g:3903:1: rule__UserResponse__Group__0 : rule__UserResponse__Group__0__Impl rule__UserResponse__Group__1 ;
    public final void rule__UserResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3907:1: ( rule__UserResponse__Group__0__Impl rule__UserResponse__Group__1 )
            // InternalQuizDSL.g:3908:2: rule__UserResponse__Group__0__Impl rule__UserResponse__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__UserResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__0"


    // $ANTLR start "rule__UserResponse__Group__0__Impl"
    // InternalQuizDSL.g:3915:1: rule__UserResponse__Group__0__Impl : ( 'question' ) ;
    public final void rule__UserResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3919:1: ( ( 'question' ) )
            // InternalQuizDSL.g:3920:1: ( 'question' )
            {
            // InternalQuizDSL.g:3920:1: ( 'question' )
            // InternalQuizDSL.g:3921:2: 'question'
            {
             before(grammarAccess.getUserResponseAccess().getQuestionKeyword_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getUserResponseAccess().getQuestionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__0__Impl"


    // $ANTLR start "rule__UserResponse__Group__1"
    // InternalQuizDSL.g:3930:1: rule__UserResponse__Group__1 : rule__UserResponse__Group__1__Impl rule__UserResponse__Group__2 ;
    public final void rule__UserResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3934:1: ( rule__UserResponse__Group__1__Impl rule__UserResponse__Group__2 )
            // InternalQuizDSL.g:3935:2: rule__UserResponse__Group__1__Impl rule__UserResponse__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__UserResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__1"


    // $ANTLR start "rule__UserResponse__Group__1__Impl"
    // InternalQuizDSL.g:3942:1: rule__UserResponse__Group__1__Impl : ( ( rule__UserResponse__QuestionAssignment_1 ) ) ;
    public final void rule__UserResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3946:1: ( ( ( rule__UserResponse__QuestionAssignment_1 ) ) )
            // InternalQuizDSL.g:3947:1: ( ( rule__UserResponse__QuestionAssignment_1 ) )
            {
            // InternalQuizDSL.g:3947:1: ( ( rule__UserResponse__QuestionAssignment_1 ) )
            // InternalQuizDSL.g:3948:2: ( rule__UserResponse__QuestionAssignment_1 )
            {
             before(grammarAccess.getUserResponseAccess().getQuestionAssignment_1()); 
            // InternalQuizDSL.g:3949:2: ( rule__UserResponse__QuestionAssignment_1 )
            // InternalQuizDSL.g:3949:3: rule__UserResponse__QuestionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UserResponse__QuestionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUserResponseAccess().getQuestionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__1__Impl"


    // $ANTLR start "rule__UserResponse__Group__2"
    // InternalQuizDSL.g:3957:1: rule__UserResponse__Group__2 : rule__UserResponse__Group__2__Impl rule__UserResponse__Group__3 ;
    public final void rule__UserResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3961:1: ( rule__UserResponse__Group__2__Impl rule__UserResponse__Group__3 )
            // InternalQuizDSL.g:3962:2: rule__UserResponse__Group__2__Impl rule__UserResponse__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__UserResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__2"


    // $ANTLR start "rule__UserResponse__Group__2__Impl"
    // InternalQuizDSL.g:3969:1: rule__UserResponse__Group__2__Impl : ( 'provided_answer' ) ;
    public final void rule__UserResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3973:1: ( ( 'provided_answer' ) )
            // InternalQuizDSL.g:3974:1: ( 'provided_answer' )
            {
            // InternalQuizDSL.g:3974:1: ( 'provided_answer' )
            // InternalQuizDSL.g:3975:2: 'provided_answer'
            {
             before(grammarAccess.getUserResponseAccess().getProvided_answerKeyword_2()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getUserResponseAccess().getProvided_answerKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__2__Impl"


    // $ANTLR start "rule__UserResponse__Group__3"
    // InternalQuizDSL.g:3984:1: rule__UserResponse__Group__3 : rule__UserResponse__Group__3__Impl rule__UserResponse__Group__4 ;
    public final void rule__UserResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:3988:1: ( rule__UserResponse__Group__3__Impl rule__UserResponse__Group__4 )
            // InternalQuizDSL.g:3989:2: rule__UserResponse__Group__3__Impl rule__UserResponse__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__UserResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__3"


    // $ANTLR start "rule__UserResponse__Group__3__Impl"
    // InternalQuizDSL.g:3996:1: rule__UserResponse__Group__3__Impl : ( ( rule__UserResponse__AnswerAssignment_3 ) ) ;
    public final void rule__UserResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4000:1: ( ( ( rule__UserResponse__AnswerAssignment_3 ) ) )
            // InternalQuizDSL.g:4001:1: ( ( rule__UserResponse__AnswerAssignment_3 ) )
            {
            // InternalQuizDSL.g:4001:1: ( ( rule__UserResponse__AnswerAssignment_3 ) )
            // InternalQuizDSL.g:4002:2: ( rule__UserResponse__AnswerAssignment_3 )
            {
             before(grammarAccess.getUserResponseAccess().getAnswerAssignment_3()); 
            // InternalQuizDSL.g:4003:2: ( rule__UserResponse__AnswerAssignment_3 )
            // InternalQuizDSL.g:4003:3: rule__UserResponse__AnswerAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__UserResponse__AnswerAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUserResponseAccess().getAnswerAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__3__Impl"


    // $ANTLR start "rule__UserResponse__Group__4"
    // InternalQuizDSL.g:4011:1: rule__UserResponse__Group__4 : rule__UserResponse__Group__4__Impl rule__UserResponse__Group__5 ;
    public final void rule__UserResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4015:1: ( rule__UserResponse__Group__4__Impl rule__UserResponse__Group__5 )
            // InternalQuizDSL.g:4016:2: rule__UserResponse__Group__4__Impl rule__UserResponse__Group__5
            {
            pushFollow(FOLLOW_36);
            rule__UserResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__4"


    // $ANTLR start "rule__UserResponse__Group__4__Impl"
    // InternalQuizDSL.g:4023:1: rule__UserResponse__Group__4__Impl : ( 'is_correct' ) ;
    public final void rule__UserResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4027:1: ( ( 'is_correct' ) )
            // InternalQuizDSL.g:4028:1: ( 'is_correct' )
            {
            // InternalQuizDSL.g:4028:1: ( 'is_correct' )
            // InternalQuizDSL.g:4029:2: 'is_correct'
            {
             before(grammarAccess.getUserResponseAccess().getIs_correctKeyword_4()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getUserResponseAccess().getIs_correctKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__4__Impl"


    // $ANTLR start "rule__UserResponse__Group__5"
    // InternalQuizDSL.g:4038:1: rule__UserResponse__Group__5 : rule__UserResponse__Group__5__Impl ;
    public final void rule__UserResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4042:1: ( rule__UserResponse__Group__5__Impl )
            // InternalQuizDSL.g:4043:2: rule__UserResponse__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UserResponse__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__5"


    // $ANTLR start "rule__UserResponse__Group__5__Impl"
    // InternalQuizDSL.g:4049:1: rule__UserResponse__Group__5__Impl : ( ( rule__UserResponse__CorrectAssignment_5 ) ) ;
    public final void rule__UserResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4053:1: ( ( ( rule__UserResponse__CorrectAssignment_5 ) ) )
            // InternalQuizDSL.g:4054:1: ( ( rule__UserResponse__CorrectAssignment_5 ) )
            {
            // InternalQuizDSL.g:4054:1: ( ( rule__UserResponse__CorrectAssignment_5 ) )
            // InternalQuizDSL.g:4055:2: ( rule__UserResponse__CorrectAssignment_5 )
            {
             before(grammarAccess.getUserResponseAccess().getCorrectAssignment_5()); 
            // InternalQuizDSL.g:4056:2: ( rule__UserResponse__CorrectAssignment_5 )
            // InternalQuizDSL.g:4056:3: rule__UserResponse__CorrectAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__UserResponse__CorrectAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getUserResponseAccess().getCorrectAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__Group__5__Impl"


    // $ANTLR start "rule__QuizGameSystem__ThemesAssignment_0"
    // InternalQuizDSL.g:4065:1: rule__QuizGameSystem__ThemesAssignment_0 : ( ruleTheme ) ;
    public final void rule__QuizGameSystem__ThemesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4069:1: ( ( ruleTheme ) )
            // InternalQuizDSL.g:4070:2: ( ruleTheme )
            {
            // InternalQuizDSL.g:4070:2: ( ruleTheme )
            // InternalQuizDSL.g:4071:3: ruleTheme
            {
             before(grammarAccess.getQuizGameSystemAccess().getThemesThemeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTheme();

            state._fsp--;

             after(grammarAccess.getQuizGameSystemAccess().getThemesThemeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizGameSystem__ThemesAssignment_0"


    // $ANTLR start "rule__QuizGameSystem__UsersAssignment_1"
    // InternalQuizDSL.g:4080:1: rule__QuizGameSystem__UsersAssignment_1 : ( ruleUser ) ;
    public final void rule__QuizGameSystem__UsersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4084:1: ( ( ruleUser ) )
            // InternalQuizDSL.g:4085:2: ( ruleUser )
            {
            // InternalQuizDSL.g:4085:2: ( ruleUser )
            // InternalQuizDSL.g:4086:3: ruleUser
            {
             before(grammarAccess.getQuizGameSystemAccess().getUsersUserParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUser();

            state._fsp--;

             after(grammarAccess.getQuizGameSystemAccess().getUsersUserParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizGameSystem__UsersAssignment_1"


    // $ANTLR start "rule__QuizGameSystem__PlatformAssignment_2"
    // InternalQuizDSL.g:4095:1: rule__QuizGameSystem__PlatformAssignment_2 : ( ruleQuizPlatform ) ;
    public final void rule__QuizGameSystem__PlatformAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4099:1: ( ( ruleQuizPlatform ) )
            // InternalQuizDSL.g:4100:2: ( ruleQuizPlatform )
            {
            // InternalQuizDSL.g:4100:2: ( ruleQuizPlatform )
            // InternalQuizDSL.g:4101:3: ruleQuizPlatform
            {
             before(grammarAccess.getQuizGameSystemAccess().getPlatformQuizPlatformParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQuizPlatform();

            state._fsp--;

             after(grammarAccess.getQuizGameSystemAccess().getPlatformQuizPlatformParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizGameSystem__PlatformAssignment_2"


    // $ANTLR start "rule__QuizGameSystem__ResultsAssignment_3"
    // InternalQuizDSL.g:4110:1: rule__QuizGameSystem__ResultsAssignment_3 : ( ruleQuizResult ) ;
    public final void rule__QuizGameSystem__ResultsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4114:1: ( ( ruleQuizResult ) )
            // InternalQuizDSL.g:4115:2: ( ruleQuizResult )
            {
            // InternalQuizDSL.g:4115:2: ( ruleQuizResult )
            // InternalQuizDSL.g:4116:3: ruleQuizResult
            {
             before(grammarAccess.getQuizGameSystemAccess().getResultsQuizResultParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleQuizResult();

            state._fsp--;

             after(grammarAccess.getQuizGameSystemAccess().getResultsQuizResultParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizGameSystem__ResultsAssignment_3"


    // $ANTLR start "rule__Theme__NameAssignment_1"
    // InternalQuizDSL.g:4125:1: rule__Theme__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Theme__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4129:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4130:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4130:2: ( RULE_ID )
            // InternalQuizDSL.g:4131:3: RULE_ID
            {
             before(grammarAccess.getThemeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__NameAssignment_1"


    // $ANTLR start "rule__Theme__PrimaryColorAssignment_3"
    // InternalQuizDSL.g:4140:1: rule__Theme__PrimaryColorAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Theme__PrimaryColorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4144:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4145:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4145:2: ( RULE_STRING )
            // InternalQuizDSL.g:4146:3: RULE_STRING
            {
             before(grammarAccess.getThemeAccess().getPrimaryColorSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getPrimaryColorSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__PrimaryColorAssignment_3"


    // $ANTLR start "rule__Theme__SecondaryColorAssignment_5"
    // InternalQuizDSL.g:4155:1: rule__Theme__SecondaryColorAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Theme__SecondaryColorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4159:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4160:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4160:2: ( RULE_STRING )
            // InternalQuizDSL.g:4161:3: RULE_STRING
            {
             before(grammarAccess.getThemeAccess().getSecondaryColorSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getSecondaryColorSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__SecondaryColorAssignment_5"


    // $ANTLR start "rule__Theme__BackgroundColorAssignment_7"
    // InternalQuizDSL.g:4170:1: rule__Theme__BackgroundColorAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Theme__BackgroundColorAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4174:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4175:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4175:2: ( RULE_STRING )
            // InternalQuizDSL.g:4176:3: RULE_STRING
            {
             before(grammarAccess.getThemeAccess().getBackgroundColorSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getBackgroundColorSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__BackgroundColorAssignment_7"


    // $ANTLR start "rule__Theme__TextColorAssignment_9"
    // InternalQuizDSL.g:4185:1: rule__Theme__TextColorAssignment_9 : ( RULE_STRING ) ;
    public final void rule__Theme__TextColorAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4189:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4190:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4190:2: ( RULE_STRING )
            // InternalQuizDSL.g:4191:3: RULE_STRING
            {
             before(grammarAccess.getThemeAccess().getTextColorSTRINGTerminalRuleCall_9_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getTextColorSTRINGTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__TextColorAssignment_9"


    // $ANTLR start "rule__Theme__FontNameAssignment_11"
    // InternalQuizDSL.g:4200:1: rule__Theme__FontNameAssignment_11 : ( RULE_STRING ) ;
    public final void rule__Theme__FontNameAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4204:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4205:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4205:2: ( RULE_STRING )
            // InternalQuizDSL.g:4206:3: RULE_STRING
            {
             before(grammarAccess.getThemeAccess().getFontNameSTRINGTerminalRuleCall_11_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getThemeAccess().getFontNameSTRINGTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Theme__FontNameAssignment_11"


    // $ANTLR start "rule__User__NameAssignment_1"
    // InternalQuizDSL.g:4215:1: rule__User__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__User__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4219:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4220:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4220:2: ( RULE_ID )
            // InternalQuizDSL.g:4221:3: RULE_ID
            {
             before(grammarAccess.getUserAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__NameAssignment_1"


    // $ANTLR start "rule__User__UsernameAssignment_3"
    // InternalQuizDSL.g:4230:1: rule__User__UsernameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__User__UsernameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4234:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4235:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4235:2: ( RULE_STRING )
            // InternalQuizDSL.g:4236:3: RULE_STRING
            {
             before(grammarAccess.getUserAccess().getUsernameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getUsernameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__UsernameAssignment_3"


    // $ANTLR start "rule__User__PasswordAssignment_5"
    // InternalQuizDSL.g:4245:1: rule__User__PasswordAssignment_5 : ( RULE_STRING ) ;
    public final void rule__User__PasswordAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4249:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4250:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4250:2: ( RULE_STRING )
            // InternalQuizDSL.g:4251:3: RULE_STRING
            {
             before(grammarAccess.getUserAccess().getPasswordSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getPasswordSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__PasswordAssignment_5"


    // $ANTLR start "rule__User__FullNameAssignment_7"
    // InternalQuizDSL.g:4260:1: rule__User__FullNameAssignment_7 : ( RULE_STRING ) ;
    public final void rule__User__FullNameAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4264:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4265:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4265:2: ( RULE_STRING )
            // InternalQuizDSL.g:4266:3: RULE_STRING
            {
             before(grammarAccess.getUserAccess().getFullNameSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getUserAccess().getFullNameSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__FullNameAssignment_7"


    // $ANTLR start "rule__User__RoleAssignment_8"
    // InternalQuizDSL.g:4275:1: rule__User__RoleAssignment_8 : ( ruleUserRole ) ;
    public final void rule__User__RoleAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4279:1: ( ( ruleUserRole ) )
            // InternalQuizDSL.g:4280:2: ( ruleUserRole )
            {
            // InternalQuizDSL.g:4280:2: ( ruleUserRole )
            // InternalQuizDSL.g:4281:3: ruleUserRole
            {
             before(grammarAccess.getUserAccess().getRoleUserRoleEnumRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleUserRole();

            state._fsp--;

             after(grammarAccess.getUserAccess().getRoleUserRoleEnumRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__RoleAssignment_8"


    // $ANTLR start "rule__QuizPlatform__NameAssignment_1"
    // InternalQuizDSL.g:4290:1: rule__QuizPlatform__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QuizPlatform__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4294:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4295:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4295:2: ( RULE_ID )
            // InternalQuizDSL.g:4296:3: RULE_ID
            {
             before(grammarAccess.getQuizPlatformAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__NameAssignment_1"


    // $ANTLR start "rule__QuizPlatform__TitleAssignment_3"
    // InternalQuizDSL.g:4305:1: rule__QuizPlatform__TitleAssignment_3 : ( RULE_STRING ) ;
    public final void rule__QuizPlatform__TitleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4309:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4310:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4310:2: ( RULE_STRING )
            // InternalQuizDSL.g:4311:3: RULE_STRING
            {
             before(grammarAccess.getQuizPlatformAccess().getTitleSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getTitleSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__TitleAssignment_3"


    // $ANTLR start "rule__QuizPlatform__SubtitleAssignment_5"
    // InternalQuizDSL.g:4320:1: rule__QuizPlatform__SubtitleAssignment_5 : ( RULE_STRING ) ;
    public final void rule__QuizPlatform__SubtitleAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4324:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4325:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4325:2: ( RULE_STRING )
            // InternalQuizDSL.g:4326:3: RULE_STRING
            {
             before(grammarAccess.getQuizPlatformAccess().getSubtitleSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getSubtitleSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__SubtitleAssignment_5"


    // $ANTLR start "rule__QuizPlatform__LogoAssignment_7"
    // InternalQuizDSL.g:4335:1: rule__QuizPlatform__LogoAssignment_7 : ( RULE_STRING ) ;
    public final void rule__QuizPlatform__LogoAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4339:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4340:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4340:2: ( RULE_STRING )
            // InternalQuizDSL.g:4341:3: RULE_STRING
            {
             before(grammarAccess.getQuizPlatformAccess().getLogoSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getLogoSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__LogoAssignment_7"


    // $ANTLR start "rule__QuizPlatform__ThemeAssignment_9"
    // InternalQuizDSL.g:4350:1: rule__QuizPlatform__ThemeAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__QuizPlatform__ThemeAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4354:1: ( ( ( RULE_ID ) ) )
            // InternalQuizDSL.g:4355:2: ( ( RULE_ID ) )
            {
            // InternalQuizDSL.g:4355:2: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4356:3: ( RULE_ID )
            {
             before(grammarAccess.getQuizPlatformAccess().getThemeThemeCrossReference_9_0()); 
            // InternalQuizDSL.g:4357:3: ( RULE_ID )
            // InternalQuizDSL.g:4358:4: RULE_ID
            {
             before(grammarAccess.getQuizPlatformAccess().getThemeThemeIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizPlatformAccess().getThemeThemeIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getQuizPlatformAccess().getThemeThemeCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__ThemeAssignment_9"


    // $ANTLR start "rule__QuizPlatform__QuizzesAssignment_10"
    // InternalQuizDSL.g:4369:1: rule__QuizPlatform__QuizzesAssignment_10 : ( ruleQuiz ) ;
    public final void rule__QuizPlatform__QuizzesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4373:1: ( ( ruleQuiz ) )
            // InternalQuizDSL.g:4374:2: ( ruleQuiz )
            {
            // InternalQuizDSL.g:4374:2: ( ruleQuiz )
            // InternalQuizDSL.g:4375:3: ruleQuiz
            {
             before(grammarAccess.getQuizPlatformAccess().getQuizzesQuizParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleQuiz();

            state._fsp--;

             after(grammarAccess.getQuizPlatformAccess().getQuizzesQuizParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizPlatform__QuizzesAssignment_10"


    // $ANTLR start "rule__Quiz__NameAssignment_1"
    // InternalQuizDSL.g:4384:1: rule__Quiz__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Quiz__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4388:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4389:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4389:2: ( RULE_ID )
            // InternalQuizDSL.g:4390:3: RULE_ID
            {
             before(grammarAccess.getQuizAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__NameAssignment_1"


    // $ANTLR start "rule__Quiz__LabelAssignment_3"
    // InternalQuizDSL.g:4399:1: rule__Quiz__LabelAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Quiz__LabelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4403:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4404:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4404:2: ( RULE_STRING )
            // InternalQuizDSL.g:4405:3: RULE_STRING
            {
             before(grammarAccess.getQuizAccess().getLabelSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getLabelSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__LabelAssignment_3"


    // $ANTLR start "rule__Quiz__DescriptionAssignment_5"
    // InternalQuizDSL.g:4414:1: rule__Quiz__DescriptionAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Quiz__DescriptionAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4418:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4419:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4419:2: ( RULE_STRING )
            // InternalQuizDSL.g:4420:3: RULE_STRING
            {
             before(grammarAccess.getQuizAccess().getDescriptionSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getDescriptionSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__DescriptionAssignment_5"


    // $ANTLR start "rule__Quiz__IconAssignment_7"
    // InternalQuizDSL.g:4429:1: rule__Quiz__IconAssignment_7 : ( RULE_STRING ) ;
    public final void rule__Quiz__IconAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4433:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4434:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4434:2: ( RULE_STRING )
            // InternalQuizDSL.g:4435:3: RULE_STRING
            {
             before(grammarAccess.getQuizAccess().getIconSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizAccess().getIconSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__IconAssignment_7"


    // $ANTLR start "rule__Quiz__ConfigAssignment_8"
    // InternalQuizDSL.g:4444:1: rule__Quiz__ConfigAssignment_8 : ( ruleQuizConfig ) ;
    public final void rule__Quiz__ConfigAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4448:1: ( ( ruleQuizConfig ) )
            // InternalQuizDSL.g:4449:2: ( ruleQuizConfig )
            {
            // InternalQuizDSL.g:4449:2: ( ruleQuizConfig )
            // InternalQuizDSL.g:4450:3: ruleQuizConfig
            {
             before(grammarAccess.getQuizAccess().getConfigQuizConfigParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleQuizConfig();

            state._fsp--;

             after(grammarAccess.getQuizAccess().getConfigQuizConfigParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__ConfigAssignment_8"


    // $ANTLR start "rule__Quiz__QuestionsAssignment_9"
    // InternalQuizDSL.g:4459:1: rule__Quiz__QuestionsAssignment_9 : ( ruleQuestion ) ;
    public final void rule__Quiz__QuestionsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4463:1: ( ( ruleQuestion ) )
            // InternalQuizDSL.g:4464:2: ( ruleQuestion )
            {
            // InternalQuizDSL.g:4464:2: ( ruleQuestion )
            // InternalQuizDSL.g:4465:3: ruleQuestion
            {
             before(grammarAccess.getQuizAccess().getQuestionsQuestionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleQuestion();

            state._fsp--;

             after(grammarAccess.getQuizAccess().getQuestionsQuestionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quiz__QuestionsAssignment_9"


    // $ANTLR start "rule__QuizConfig__AccessAssignment_1"
    // InternalQuizDSL.g:4474:1: rule__QuizConfig__AccessAssignment_1 : ( ruleAccessType ) ;
    public final void rule__QuizConfig__AccessAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4478:1: ( ( ruleAccessType ) )
            // InternalQuizDSL.g:4479:2: ( ruleAccessType )
            {
            // InternalQuizDSL.g:4479:2: ( ruleAccessType )
            // InternalQuizDSL.g:4480:3: ruleAccessType
            {
             before(grammarAccess.getQuizConfigAccess().getAccessAccessTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAccessType();

            state._fsp--;

             after(grammarAccess.getQuizConfigAccess().getAccessAccessTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__AccessAssignment_1"


    // $ANTLR start "rule__QuizConfig__DurationAssignment_2_1"
    // InternalQuizDSL.g:4489:1: rule__QuizConfig__DurationAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__QuizConfig__DurationAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4493:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4494:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4494:2: ( RULE_INT )
            // InternalQuizDSL.g:4495:3: RULE_INT
            {
             before(grammarAccess.getQuizConfigAccess().getDurationINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getDurationINTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__DurationAssignment_2_1"


    // $ANTLR start "rule__QuizConfig__StartTimeAssignment_3_1"
    // InternalQuizDSL.g:4504:1: rule__QuizConfig__StartTimeAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__QuizConfig__StartTimeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4508:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4509:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4509:2: ( RULE_STRING )
            // InternalQuizDSL.g:4510:3: RULE_STRING
            {
             before(grammarAccess.getQuizConfigAccess().getStartTimeSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getStartTimeSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__StartTimeAssignment_3_1"


    // $ANTLR start "rule__QuizConfig__EndTimeAssignment_4_1"
    // InternalQuizDSL.g:4519:1: rule__QuizConfig__EndTimeAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__QuizConfig__EndTimeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4523:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4524:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4524:2: ( RULE_STRING )
            // InternalQuizDSL.g:4525:3: RULE_STRING
            {
             before(grammarAccess.getQuizConfigAccess().getEndTimeSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getEndTimeSTRINGTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__EndTimeAssignment_4_1"


    // $ANTLR start "rule__QuizConfig__ShuffleQuestionsAssignment_5"
    // InternalQuizDSL.g:4534:1: rule__QuizConfig__ShuffleQuestionsAssignment_5 : ( ( 'shuffle' ) ) ;
    public final void rule__QuizConfig__ShuffleQuestionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4538:1: ( ( ( 'shuffle' ) ) )
            // InternalQuizDSL.g:4539:2: ( ( 'shuffle' ) )
            {
            // InternalQuizDSL.g:4539:2: ( ( 'shuffle' ) )
            // InternalQuizDSL.g:4540:3: ( 'shuffle' )
            {
             before(grammarAccess.getQuizConfigAccess().getShuffleQuestionsShuffleKeyword_5_0()); 
            // InternalQuizDSL.g:4541:3: ( 'shuffle' )
            // InternalQuizDSL.g:4542:4: 'shuffle'
            {
             before(grammarAccess.getQuizConfigAccess().getShuffleQuestionsShuffleKeyword_5_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getShuffleQuestionsShuffleKeyword_5_0()); 

            }

             after(grammarAccess.getQuizConfigAccess().getShuffleQuestionsShuffleKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__ShuffleQuestionsAssignment_5"


    // $ANTLR start "rule__QuizConfig__ShowResultAssignment_6"
    // InternalQuizDSL.g:4553:1: rule__QuizConfig__ShowResultAssignment_6 : ( ( 'show_result' ) ) ;
    public final void rule__QuizConfig__ShowResultAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4557:1: ( ( ( 'show_result' ) ) )
            // InternalQuizDSL.g:4558:2: ( ( 'show_result' ) )
            {
            // InternalQuizDSL.g:4558:2: ( ( 'show_result' ) )
            // InternalQuizDSL.g:4559:3: ( 'show_result' )
            {
             before(grammarAccess.getQuizConfigAccess().getShowResultShow_resultKeyword_6_0()); 
            // InternalQuizDSL.g:4560:3: ( 'show_result' )
            // InternalQuizDSL.g:4561:4: 'show_result'
            {
             before(grammarAccess.getQuizConfigAccess().getShowResultShow_resultKeyword_6_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getShowResultShow_resultKeyword_6_0()); 

            }

             after(grammarAccess.getQuizConfigAccess().getShowResultShow_resultKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__ShowResultAssignment_6"


    // $ANTLR start "rule__QuizConfig__TotalScoreAssignment_7_1"
    // InternalQuizDSL.g:4572:1: rule__QuizConfig__TotalScoreAssignment_7_1 : ( RULE_INT ) ;
    public final void rule__QuizConfig__TotalScoreAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4576:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4577:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4577:2: ( RULE_INT )
            // InternalQuizDSL.g:4578:3: RULE_INT
            {
             before(grammarAccess.getQuizConfigAccess().getTotalScoreINTTerminalRuleCall_7_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getQuizConfigAccess().getTotalScoreINTTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizConfig__TotalScoreAssignment_7_1"


    // $ANTLR start "rule__SingleChoiceQuestion__NameAssignment_1"
    // InternalQuizDSL.g:4587:1: rule__SingleChoiceQuestion__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SingleChoiceQuestion__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4591:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4592:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4592:2: ( RULE_ID )
            // InternalQuizDSL.g:4593:3: RULE_ID
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__NameAssignment_1"


    // $ANTLR start "rule__SingleChoiceQuestion__TextAssignment_3"
    // InternalQuizDSL.g:4602:1: rule__SingleChoiceQuestion__TextAssignment_3 : ( RULE_STRING ) ;
    public final void rule__SingleChoiceQuestion__TextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4606:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4607:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4607:2: ( RULE_STRING )
            // InternalQuizDSL.g:4608:3: RULE_STRING
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__TextAssignment_3"


    // $ANTLR start "rule__SingleChoiceQuestion__ScoreAssignment_4_1"
    // InternalQuizDSL.g:4617:1: rule__SingleChoiceQuestion__ScoreAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__SingleChoiceQuestion__ScoreAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4621:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4622:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4622:2: ( RULE_INT )
            // InternalQuizDSL.g:4623:3: RULE_INT
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__ScoreAssignment_4_1"


    // $ANTLR start "rule__SingleChoiceQuestion__MediaUrlAssignment_5_1"
    // InternalQuizDSL.g:4632:1: rule__SingleChoiceQuestion__MediaUrlAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__SingleChoiceQuestion__MediaUrlAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4636:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4637:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4637:2: ( RULE_STRING )
            // InternalQuizDSL.g:4638:3: RULE_STRING
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getMediaUrlSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getMediaUrlSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__MediaUrlAssignment_5_1"


    // $ANTLR start "rule__SingleChoiceQuestion__OptionsAssignment_7"
    // InternalQuizDSL.g:4647:1: rule__SingleChoiceQuestion__OptionsAssignment_7 : ( ruleOption ) ;
    public final void rule__SingleChoiceQuestion__OptionsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4651:1: ( ( ruleOption ) )
            // InternalQuizDSL.g:4652:2: ( ruleOption )
            {
            // InternalQuizDSL.g:4652:2: ( ruleOption )
            // InternalQuizDSL.g:4653:3: ruleOption
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getOptionsOptionParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getSingleChoiceQuestionAccess().getOptionsOptionParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__OptionsAssignment_7"


    // $ANTLR start "rule__SingleChoiceQuestion__CorrectOptionAssignment_9"
    // InternalQuizDSL.g:4662:1: rule__SingleChoiceQuestion__CorrectOptionAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__SingleChoiceQuestion__CorrectOptionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4666:1: ( ( ( RULE_ID ) ) )
            // InternalQuizDSL.g:4667:2: ( ( RULE_ID ) )
            {
            // InternalQuizDSL.g:4667:2: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4668:3: ( RULE_ID )
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionOptionCrossReference_9_0()); 
            // InternalQuizDSL.g:4669:3: ( RULE_ID )
            // InternalQuizDSL.g:4670:4: RULE_ID
            {
             before(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionOptionIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionOptionIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionOptionCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingleChoiceQuestion__CorrectOptionAssignment_9"


    // $ANTLR start "rule__MultipleChoiceQuestion__NameAssignment_1"
    // InternalQuizDSL.g:4681:1: rule__MultipleChoiceQuestion__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MultipleChoiceQuestion__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4685:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4686:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4686:2: ( RULE_ID )
            // InternalQuizDSL.g:4687:3: RULE_ID
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__NameAssignment_1"


    // $ANTLR start "rule__MultipleChoiceQuestion__TextAssignment_3"
    // InternalQuizDSL.g:4696:1: rule__MultipleChoiceQuestion__TextAssignment_3 : ( RULE_STRING ) ;
    public final void rule__MultipleChoiceQuestion__TextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4700:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4701:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4701:2: ( RULE_STRING )
            // InternalQuizDSL.g:4702:3: RULE_STRING
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__TextAssignment_3"


    // $ANTLR start "rule__MultipleChoiceQuestion__ScoreAssignment_4_1"
    // InternalQuizDSL.g:4711:1: rule__MultipleChoiceQuestion__ScoreAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__MultipleChoiceQuestion__ScoreAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4715:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4716:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4716:2: ( RULE_INT )
            // InternalQuizDSL.g:4717:3: RULE_INT
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMultipleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__ScoreAssignment_4_1"


    // $ANTLR start "rule__MultipleChoiceQuestion__OptionsAssignment_6"
    // InternalQuizDSL.g:4726:1: rule__MultipleChoiceQuestion__OptionsAssignment_6 : ( ruleOption ) ;
    public final void rule__MultipleChoiceQuestion__OptionsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4730:1: ( ( ruleOption ) )
            // InternalQuizDSL.g:4731:2: ( ruleOption )
            {
            // InternalQuizDSL.g:4731:2: ( ruleOption )
            // InternalQuizDSL.g:4732:3: ruleOption
            {
             before(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsOptionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsOptionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultipleChoiceQuestion__OptionsAssignment_6"


    // $ANTLR start "rule__TrueFalseQuestion__NameAssignment_1"
    // InternalQuizDSL.g:4741:1: rule__TrueFalseQuestion__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TrueFalseQuestion__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4745:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4746:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4746:2: ( RULE_ID )
            // InternalQuizDSL.g:4747:3: RULE_ID
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__NameAssignment_1"


    // $ANTLR start "rule__TrueFalseQuestion__TextAssignment_3"
    // InternalQuizDSL.g:4756:1: rule__TrueFalseQuestion__TextAssignment_3 : ( RULE_STRING ) ;
    public final void rule__TrueFalseQuestion__TextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4760:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4761:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4761:2: ( RULE_STRING )
            // InternalQuizDSL.g:4762:3: RULE_STRING
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__TextAssignment_3"


    // $ANTLR start "rule__TrueFalseQuestion__ScoreAssignment_4_1"
    // InternalQuizDSL.g:4771:1: rule__TrueFalseQuestion__ScoreAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__TrueFalseQuestion__ScoreAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4775:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4776:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4776:2: ( RULE_INT )
            // InternalQuizDSL.g:4777:3: RULE_INT
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTrueFalseQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__ScoreAssignment_4_1"


    // $ANTLR start "rule__TrueFalseQuestion__IsTrueAssignment_6"
    // InternalQuizDSL.g:4786:1: rule__TrueFalseQuestion__IsTrueAssignment_6 : ( ruleEBoolean ) ;
    public final void rule__TrueFalseQuestion__IsTrueAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4790:1: ( ( ruleEBoolean ) )
            // InternalQuizDSL.g:4791:2: ( ruleEBoolean )
            {
            // InternalQuizDSL.g:4791:2: ( ruleEBoolean )
            // InternalQuizDSL.g:4792:3: ruleEBoolean
            {
             before(grammarAccess.getTrueFalseQuestionAccess().getIsTrueEBooleanParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getTrueFalseQuestionAccess().getIsTrueEBooleanParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFalseQuestion__IsTrueAssignment_6"


    // $ANTLR start "rule__DescriptiveQuestion__NameAssignment_1"
    // InternalQuizDSL.g:4801:1: rule__DescriptiveQuestion__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DescriptiveQuestion__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4805:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4806:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4806:2: ( RULE_ID )
            // InternalQuizDSL.g:4807:3: RULE_ID
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__NameAssignment_1"


    // $ANTLR start "rule__DescriptiveQuestion__TextAssignment_3"
    // InternalQuizDSL.g:4816:1: rule__DescriptiveQuestion__TextAssignment_3 : ( RULE_STRING ) ;
    public final void rule__DescriptiveQuestion__TextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4820:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4821:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4821:2: ( RULE_STRING )
            // InternalQuizDSL.g:4822:3: RULE_STRING
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getTextSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__TextAssignment_3"


    // $ANTLR start "rule__DescriptiveQuestion__ScoreAssignment_4_1"
    // InternalQuizDSL.g:4831:1: rule__DescriptiveQuestion__ScoreAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__DescriptiveQuestion__ScoreAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4835:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4836:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4836:2: ( RULE_INT )
            // InternalQuizDSL.g:4837:3: RULE_INT
            {
             before(grammarAccess.getDescriptiveQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDescriptiveQuestionAccess().getScoreINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptiveQuestion__ScoreAssignment_4_1"


    // $ANTLR start "rule__Option__NameAssignment_0"
    // InternalQuizDSL.g:4846:1: rule__Option__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Option__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4850:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4851:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4851:2: ( RULE_ID )
            // InternalQuizDSL.g:4852:3: RULE_ID
            {
             before(grammarAccess.getOptionAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__NameAssignment_0"


    // $ANTLR start "rule__Option__TextAssignment_2"
    // InternalQuizDSL.g:4861:1: rule__Option__TextAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Option__TextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4865:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4866:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4866:2: ( RULE_STRING )
            // InternalQuizDSL.g:4867:3: RULE_STRING
            {
             before(grammarAccess.getOptionAccess().getTextSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getTextSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__TextAssignment_2"


    // $ANTLR start "rule__QuizResult__NameAssignment_1"
    // InternalQuizDSL.g:4876:1: rule__QuizResult__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QuizResult__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4880:1: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4881:2: ( RULE_ID )
            {
            // InternalQuizDSL.g:4881:2: ( RULE_ID )
            // InternalQuizDSL.g:4882:3: RULE_ID
            {
             before(grammarAccess.getQuizResultAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__NameAssignment_1"


    // $ANTLR start "rule__QuizResult__UserAssignment_3"
    // InternalQuizDSL.g:4891:1: rule__QuizResult__UserAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__QuizResult__UserAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4895:1: ( ( ( RULE_ID ) ) )
            // InternalQuizDSL.g:4896:2: ( ( RULE_ID ) )
            {
            // InternalQuizDSL.g:4896:2: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4897:3: ( RULE_ID )
            {
             before(grammarAccess.getQuizResultAccess().getUserUserCrossReference_3_0()); 
            // InternalQuizDSL.g:4898:3: ( RULE_ID )
            // InternalQuizDSL.g:4899:4: RULE_ID
            {
             before(grammarAccess.getQuizResultAccess().getUserUserIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getUserUserIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getQuizResultAccess().getUserUserCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__UserAssignment_3"


    // $ANTLR start "rule__QuizResult__QuizAssignment_5"
    // InternalQuizDSL.g:4910:1: rule__QuizResult__QuizAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__QuizResult__QuizAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4914:1: ( ( ( RULE_ID ) ) )
            // InternalQuizDSL.g:4915:2: ( ( RULE_ID ) )
            {
            // InternalQuizDSL.g:4915:2: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4916:3: ( RULE_ID )
            {
             before(grammarAccess.getQuizResultAccess().getQuizQuizCrossReference_5_0()); 
            // InternalQuizDSL.g:4917:3: ( RULE_ID )
            // InternalQuizDSL.g:4918:4: RULE_ID
            {
             before(grammarAccess.getQuizResultAccess().getQuizQuizIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getQuizQuizIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getQuizResultAccess().getQuizQuizCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__QuizAssignment_5"


    // $ANTLR start "rule__QuizResult__FinalScoreAssignment_7"
    // InternalQuizDSL.g:4929:1: rule__QuizResult__FinalScoreAssignment_7 : ( RULE_INT ) ;
    public final void rule__QuizResult__FinalScoreAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4933:1: ( ( RULE_INT ) )
            // InternalQuizDSL.g:4934:2: ( RULE_INT )
            {
            // InternalQuizDSL.g:4934:2: ( RULE_INT )
            // InternalQuizDSL.g:4935:3: RULE_INT
            {
             before(grammarAccess.getQuizResultAccess().getFinalScoreINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getQuizResultAccess().getFinalScoreINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__FinalScoreAssignment_7"


    // $ANTLR start "rule__QuizResult__ResponsesAssignment_10"
    // InternalQuizDSL.g:4944:1: rule__QuizResult__ResponsesAssignment_10 : ( ruleUserResponse ) ;
    public final void rule__QuizResult__ResponsesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4948:1: ( ( ruleUserResponse ) )
            // InternalQuizDSL.g:4949:2: ( ruleUserResponse )
            {
            // InternalQuizDSL.g:4949:2: ( ruleUserResponse )
            // InternalQuizDSL.g:4950:3: ruleUserResponse
            {
             before(grammarAccess.getQuizResultAccess().getResponsesUserResponseParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleUserResponse();

            state._fsp--;

             after(grammarAccess.getQuizResultAccess().getResponsesUserResponseParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuizResult__ResponsesAssignment_10"


    // $ANTLR start "rule__UserResponse__QuestionAssignment_1"
    // InternalQuizDSL.g:4959:1: rule__UserResponse__QuestionAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__UserResponse__QuestionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4963:1: ( ( ( RULE_ID ) ) )
            // InternalQuizDSL.g:4964:2: ( ( RULE_ID ) )
            {
            // InternalQuizDSL.g:4964:2: ( ( RULE_ID ) )
            // InternalQuizDSL.g:4965:3: ( RULE_ID )
            {
             before(grammarAccess.getUserResponseAccess().getQuestionQuestionCrossReference_1_0()); 
            // InternalQuizDSL.g:4966:3: ( RULE_ID )
            // InternalQuizDSL.g:4967:4: RULE_ID
            {
             before(grammarAccess.getUserResponseAccess().getQuestionQuestionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUserResponseAccess().getQuestionQuestionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getUserResponseAccess().getQuestionQuestionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__QuestionAssignment_1"


    // $ANTLR start "rule__UserResponse__AnswerAssignment_3"
    // InternalQuizDSL.g:4978:1: rule__UserResponse__AnswerAssignment_3 : ( RULE_STRING ) ;
    public final void rule__UserResponse__AnswerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4982:1: ( ( RULE_STRING ) )
            // InternalQuizDSL.g:4983:2: ( RULE_STRING )
            {
            // InternalQuizDSL.g:4983:2: ( RULE_STRING )
            // InternalQuizDSL.g:4984:3: RULE_STRING
            {
             before(grammarAccess.getUserResponseAccess().getAnswerSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getUserResponseAccess().getAnswerSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__AnswerAssignment_3"


    // $ANTLR start "rule__UserResponse__CorrectAssignment_5"
    // InternalQuizDSL.g:4993:1: rule__UserResponse__CorrectAssignment_5 : ( ruleEBoolean ) ;
    public final void rule__UserResponse__CorrectAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalQuizDSL.g:4997:1: ( ( ruleEBoolean ) )
            // InternalQuizDSL.g:4998:2: ( ruleEBoolean )
            {
            // InternalQuizDSL.g:4998:2: ( ruleEBoolean )
            // InternalQuizDSL.g:4999:3: ruleEBoolean
            {
             before(grammarAccess.getUserResponseAccess().getCorrectEBooleanParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getUserResponseAccess().getCorrectEBooleanParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserResponse__CorrectAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0008000011020002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000806000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0002C20000800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0002C20000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0C0001A000800000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000340000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000800000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0200000000000000L});

}