package org.example.quiz.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.example.quiz.services.QuizDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQuizDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'theme'", "'primary'", "'secondary'", "'bg'", "'text'", "'font'", "'end'", "'user'", "'uid'", "'pwd'", "'name'", "'platform'", "'title'", "'subtitle'", "'logo'", "'use_theme'", "'quiz'", "'label'", "'desc'", "'icon'", "'time'", "'min'", "'start'", "'shuffle'", "'show_result'", "'score'", "'single_choice'", "'val'", "'media'", "'options'", "'correct'", "'multi_choice'", "'true_false'", "'answer'", "'descriptive'", "'->'", "'true'", "'false'", "'result'", "'responses'", "'{'", "'}'", "'question'", "'provided_answer'", "'is_correct'", "'admin'", "'student'", "'public'", "'private'"
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

        public InternalQuizDSLParser(TokenStream input, QuizDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "QuizGameSystem";
       	}

       	@Override
       	protected QuizDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleQuizGameSystem"
    // InternalQuizDSL.g:65:1: entryRuleQuizGameSystem returns [EObject current=null] : iv_ruleQuizGameSystem= ruleQuizGameSystem EOF ;
    public final EObject entryRuleQuizGameSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuizGameSystem = null;


        try {
            // InternalQuizDSL.g:65:55: (iv_ruleQuizGameSystem= ruleQuizGameSystem EOF )
            // InternalQuizDSL.g:66:2: iv_ruleQuizGameSystem= ruleQuizGameSystem EOF
            {
             newCompositeNode(grammarAccess.getQuizGameSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuizGameSystem=ruleQuizGameSystem();

            state._fsp--;

             current =iv_ruleQuizGameSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuizGameSystem"


    // $ANTLR start "ruleQuizGameSystem"
    // InternalQuizDSL.g:72:1: ruleQuizGameSystem returns [EObject current=null] : ( ( (lv_themes_0_0= ruleTheme ) ) | ( (lv_users_1_0= ruleUser ) ) | ( (lv_platform_2_0= ruleQuizPlatform ) ) | ( (lv_results_3_0= ruleQuizResult ) ) )* ;
    public final EObject ruleQuizGameSystem() throws RecognitionException {
        EObject current = null;

        EObject lv_themes_0_0 = null;

        EObject lv_users_1_0 = null;

        EObject lv_platform_2_0 = null;

        EObject lv_results_3_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:78:2: ( ( ( (lv_themes_0_0= ruleTheme ) ) | ( (lv_users_1_0= ruleUser ) ) | ( (lv_platform_2_0= ruleQuizPlatform ) ) | ( (lv_results_3_0= ruleQuizResult ) ) )* )
            // InternalQuizDSL.g:79:2: ( ( (lv_themes_0_0= ruleTheme ) ) | ( (lv_users_1_0= ruleUser ) ) | ( (lv_platform_2_0= ruleQuizPlatform ) ) | ( (lv_results_3_0= ruleQuizResult ) ) )*
            {
            // InternalQuizDSL.g:79:2: ( ( (lv_themes_0_0= ruleTheme ) ) | ( (lv_users_1_0= ruleUser ) ) | ( (lv_platform_2_0= ruleQuizPlatform ) ) | ( (lv_results_3_0= ruleQuizResult ) ) )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 11:
                    {
                    alt1=1;
                    }
                    break;
                case 18:
                    {
                    alt1=2;
                    }
                    break;
                case 22:
                    {
                    alt1=3;
                    }
                    break;
                case 49:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalQuizDSL.g:80:3: ( (lv_themes_0_0= ruleTheme ) )
            	    {
            	    // InternalQuizDSL.g:80:3: ( (lv_themes_0_0= ruleTheme ) )
            	    // InternalQuizDSL.g:81:4: (lv_themes_0_0= ruleTheme )
            	    {
            	    // InternalQuizDSL.g:81:4: (lv_themes_0_0= ruleTheme )
            	    // InternalQuizDSL.g:82:5: lv_themes_0_0= ruleTheme
            	    {

            	    					newCompositeNode(grammarAccess.getQuizGameSystemAccess().getThemesThemeParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_themes_0_0=ruleTheme();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizGameSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"themes",
            	    						lv_themes_0_0,
            	    						"org.example.quiz.QuizDSL.Theme");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalQuizDSL.g:100:3: ( (lv_users_1_0= ruleUser ) )
            	    {
            	    // InternalQuizDSL.g:100:3: ( (lv_users_1_0= ruleUser ) )
            	    // InternalQuizDSL.g:101:4: (lv_users_1_0= ruleUser )
            	    {
            	    // InternalQuizDSL.g:101:4: (lv_users_1_0= ruleUser )
            	    // InternalQuizDSL.g:102:5: lv_users_1_0= ruleUser
            	    {

            	    					newCompositeNode(grammarAccess.getQuizGameSystemAccess().getUsersUserParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_users_1_0=ruleUser();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizGameSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"users",
            	    						lv_users_1_0,
            	    						"org.example.quiz.QuizDSL.User");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalQuizDSL.g:120:3: ( (lv_platform_2_0= ruleQuizPlatform ) )
            	    {
            	    // InternalQuizDSL.g:120:3: ( (lv_platform_2_0= ruleQuizPlatform ) )
            	    // InternalQuizDSL.g:121:4: (lv_platform_2_0= ruleQuizPlatform )
            	    {
            	    // InternalQuizDSL.g:121:4: (lv_platform_2_0= ruleQuizPlatform )
            	    // InternalQuizDSL.g:122:5: lv_platform_2_0= ruleQuizPlatform
            	    {

            	    					newCompositeNode(grammarAccess.getQuizGameSystemAccess().getPlatformQuizPlatformParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_platform_2_0=ruleQuizPlatform();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizGameSystemRule());
            	    					}
            	    					set(
            	    						current,
            	    						"platform",
            	    						lv_platform_2_0,
            	    						"org.example.quiz.QuizDSL.QuizPlatform");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalQuizDSL.g:140:3: ( (lv_results_3_0= ruleQuizResult ) )
            	    {
            	    // InternalQuizDSL.g:140:3: ( (lv_results_3_0= ruleQuizResult ) )
            	    // InternalQuizDSL.g:141:4: (lv_results_3_0= ruleQuizResult )
            	    {
            	    // InternalQuizDSL.g:141:4: (lv_results_3_0= ruleQuizResult )
            	    // InternalQuizDSL.g:142:5: lv_results_3_0= ruleQuizResult
            	    {

            	    					newCompositeNode(grammarAccess.getQuizGameSystemAccess().getResultsQuizResultParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_results_3_0=ruleQuizResult();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizGameSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"results",
            	    						lv_results_3_0,
            	    						"org.example.quiz.QuizDSL.QuizResult");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuizGameSystem"


    // $ANTLR start "entryRuleTheme"
    // InternalQuizDSL.g:163:1: entryRuleTheme returns [EObject current=null] : iv_ruleTheme= ruleTheme EOF ;
    public final EObject entryRuleTheme() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTheme = null;


        try {
            // InternalQuizDSL.g:163:46: (iv_ruleTheme= ruleTheme EOF )
            // InternalQuizDSL.g:164:2: iv_ruleTheme= ruleTheme EOF
            {
             newCompositeNode(grammarAccess.getThemeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTheme=ruleTheme();

            state._fsp--;

             current =iv_ruleTheme; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTheme"


    // $ANTLR start "ruleTheme"
    // InternalQuizDSL.g:170:1: ruleTheme returns [EObject current=null] : (otherlv_0= 'theme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'primary' ( (lv_primaryColor_3_0= RULE_STRING ) ) otherlv_4= 'secondary' ( (lv_secondaryColor_5_0= RULE_STRING ) ) otherlv_6= 'bg' ( (lv_backgroundColor_7_0= RULE_STRING ) ) otherlv_8= 'text' ( (lv_textColor_9_0= RULE_STRING ) ) otherlv_10= 'font' ( (lv_fontName_11_0= RULE_STRING ) ) otherlv_12= 'end' ) ;
    public final EObject ruleTheme() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_primaryColor_3_0=null;
        Token otherlv_4=null;
        Token lv_secondaryColor_5_0=null;
        Token otherlv_6=null;
        Token lv_backgroundColor_7_0=null;
        Token otherlv_8=null;
        Token lv_textColor_9_0=null;
        Token otherlv_10=null;
        Token lv_fontName_11_0=null;
        Token otherlv_12=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:176:2: ( (otherlv_0= 'theme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'primary' ( (lv_primaryColor_3_0= RULE_STRING ) ) otherlv_4= 'secondary' ( (lv_secondaryColor_5_0= RULE_STRING ) ) otherlv_6= 'bg' ( (lv_backgroundColor_7_0= RULE_STRING ) ) otherlv_8= 'text' ( (lv_textColor_9_0= RULE_STRING ) ) otherlv_10= 'font' ( (lv_fontName_11_0= RULE_STRING ) ) otherlv_12= 'end' ) )
            // InternalQuizDSL.g:177:2: (otherlv_0= 'theme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'primary' ( (lv_primaryColor_3_0= RULE_STRING ) ) otherlv_4= 'secondary' ( (lv_secondaryColor_5_0= RULE_STRING ) ) otherlv_6= 'bg' ( (lv_backgroundColor_7_0= RULE_STRING ) ) otherlv_8= 'text' ( (lv_textColor_9_0= RULE_STRING ) ) otherlv_10= 'font' ( (lv_fontName_11_0= RULE_STRING ) ) otherlv_12= 'end' )
            {
            // InternalQuizDSL.g:177:2: (otherlv_0= 'theme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'primary' ( (lv_primaryColor_3_0= RULE_STRING ) ) otherlv_4= 'secondary' ( (lv_secondaryColor_5_0= RULE_STRING ) ) otherlv_6= 'bg' ( (lv_backgroundColor_7_0= RULE_STRING ) ) otherlv_8= 'text' ( (lv_textColor_9_0= RULE_STRING ) ) otherlv_10= 'font' ( (lv_fontName_11_0= RULE_STRING ) ) otherlv_12= 'end' )
            // InternalQuizDSL.g:178:3: otherlv_0= 'theme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'primary' ( (lv_primaryColor_3_0= RULE_STRING ) ) otherlv_4= 'secondary' ( (lv_secondaryColor_5_0= RULE_STRING ) ) otherlv_6= 'bg' ( (lv_backgroundColor_7_0= RULE_STRING ) ) otherlv_8= 'text' ( (lv_textColor_9_0= RULE_STRING ) ) otherlv_10= 'font' ( (lv_fontName_11_0= RULE_STRING ) ) otherlv_12= 'end'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getThemeAccess().getThemeKeyword_0());
            		
            // InternalQuizDSL.g:182:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:183:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:183:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:184:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getThemeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getThemeAccess().getPrimaryKeyword_2());
            		
            // InternalQuizDSL.g:204:3: ( (lv_primaryColor_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:205:4: (lv_primaryColor_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:205:4: (lv_primaryColor_3_0= RULE_STRING )
            // InternalQuizDSL.g:206:5: lv_primaryColor_3_0= RULE_STRING
            {
            lv_primaryColor_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_primaryColor_3_0, grammarAccess.getThemeAccess().getPrimaryColorSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"primaryColor",
            						lv_primaryColor_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getThemeAccess().getSecondaryKeyword_4());
            		
            // InternalQuizDSL.g:226:3: ( (lv_secondaryColor_5_0= RULE_STRING ) )
            // InternalQuizDSL.g:227:4: (lv_secondaryColor_5_0= RULE_STRING )
            {
            // InternalQuizDSL.g:227:4: (lv_secondaryColor_5_0= RULE_STRING )
            // InternalQuizDSL.g:228:5: lv_secondaryColor_5_0= RULE_STRING
            {
            lv_secondaryColor_5_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_secondaryColor_5_0, grammarAccess.getThemeAccess().getSecondaryColorSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"secondaryColor",
            						lv_secondaryColor_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getThemeAccess().getBgKeyword_6());
            		
            // InternalQuizDSL.g:248:3: ( (lv_backgroundColor_7_0= RULE_STRING ) )
            // InternalQuizDSL.g:249:4: (lv_backgroundColor_7_0= RULE_STRING )
            {
            // InternalQuizDSL.g:249:4: (lv_backgroundColor_7_0= RULE_STRING )
            // InternalQuizDSL.g:250:5: lv_backgroundColor_7_0= RULE_STRING
            {
            lv_backgroundColor_7_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_backgroundColor_7_0, grammarAccess.getThemeAccess().getBackgroundColorSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"backgroundColor",
            						lv_backgroundColor_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getThemeAccess().getTextKeyword_8());
            		
            // InternalQuizDSL.g:270:3: ( (lv_textColor_9_0= RULE_STRING ) )
            // InternalQuizDSL.g:271:4: (lv_textColor_9_0= RULE_STRING )
            {
            // InternalQuizDSL.g:271:4: (lv_textColor_9_0= RULE_STRING )
            // InternalQuizDSL.g:272:5: lv_textColor_9_0= RULE_STRING
            {
            lv_textColor_9_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_textColor_9_0, grammarAccess.getThemeAccess().getTextColorSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"textColor",
            						lv_textColor_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_10, grammarAccess.getThemeAccess().getFontKeyword_10());
            		
            // InternalQuizDSL.g:292:3: ( (lv_fontName_11_0= RULE_STRING ) )
            // InternalQuizDSL.g:293:4: (lv_fontName_11_0= RULE_STRING )
            {
            // InternalQuizDSL.g:293:4: (lv_fontName_11_0= RULE_STRING )
            // InternalQuizDSL.g:294:5: lv_fontName_11_0= RULE_STRING
            {
            lv_fontName_11_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_fontName_11_0, grammarAccess.getThemeAccess().getFontNameSTRINGTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThemeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"fontName",
            						lv_fontName_11_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getThemeAccess().getEndKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTheme"


    // $ANTLR start "entryRuleUser"
    // InternalQuizDSL.g:318:1: entryRuleUser returns [EObject current=null] : iv_ruleUser= ruleUser EOF ;
    public final EObject entryRuleUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUser = null;


        try {
            // InternalQuizDSL.g:318:45: (iv_ruleUser= ruleUser EOF )
            // InternalQuizDSL.g:319:2: iv_ruleUser= ruleUser EOF
            {
             newCompositeNode(grammarAccess.getUserRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUser=ruleUser();

            state._fsp--;

             current =iv_ruleUser; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUser"


    // $ANTLR start "ruleUser"
    // InternalQuizDSL.g:325:1: ruleUser returns [EObject current=null] : (otherlv_0= 'user' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uid' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'pwd' ( (lv_password_5_0= RULE_STRING ) ) otherlv_6= 'name' ( (lv_fullName_7_0= RULE_STRING ) ) ( (lv_role_8_0= ruleUserRole ) )? otherlv_9= 'end' ) ;
    public final EObject ruleUser() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_username_3_0=null;
        Token otherlv_4=null;
        Token lv_password_5_0=null;
        Token otherlv_6=null;
        Token lv_fullName_7_0=null;
        Token otherlv_9=null;
        Enumerator lv_role_8_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:331:2: ( (otherlv_0= 'user' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uid' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'pwd' ( (lv_password_5_0= RULE_STRING ) ) otherlv_6= 'name' ( (lv_fullName_7_0= RULE_STRING ) ) ( (lv_role_8_0= ruleUserRole ) )? otherlv_9= 'end' ) )
            // InternalQuizDSL.g:332:2: (otherlv_0= 'user' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uid' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'pwd' ( (lv_password_5_0= RULE_STRING ) ) otherlv_6= 'name' ( (lv_fullName_7_0= RULE_STRING ) ) ( (lv_role_8_0= ruleUserRole ) )? otherlv_9= 'end' )
            {
            // InternalQuizDSL.g:332:2: (otherlv_0= 'user' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uid' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'pwd' ( (lv_password_5_0= RULE_STRING ) ) otherlv_6= 'name' ( (lv_fullName_7_0= RULE_STRING ) ) ( (lv_role_8_0= ruleUserRole ) )? otherlv_9= 'end' )
            // InternalQuizDSL.g:333:3: otherlv_0= 'user' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uid' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'pwd' ( (lv_password_5_0= RULE_STRING ) ) otherlv_6= 'name' ( (lv_fullName_7_0= RULE_STRING ) ) ( (lv_role_8_0= ruleUserRole ) )? otherlv_9= 'end'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUserAccess().getUserKeyword_0());
            		
            // InternalQuizDSL.g:337:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:338:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:338:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:339:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUserAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUserAccess().getUidKeyword_2());
            		
            // InternalQuizDSL.g:359:3: ( (lv_username_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:360:4: (lv_username_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:360:4: (lv_username_3_0= RULE_STRING )
            // InternalQuizDSL.g:361:5: lv_username_3_0= RULE_STRING
            {
            lv_username_3_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            					newLeafNode(lv_username_3_0, grammarAccess.getUserAccess().getUsernameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserRule());
            					}
            					setWithLastConsumed(
            						current,
            						"username",
            						lv_username_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getUserAccess().getPwdKeyword_4());
            		
            // InternalQuizDSL.g:381:3: ( (lv_password_5_0= RULE_STRING ) )
            // InternalQuizDSL.g:382:4: (lv_password_5_0= RULE_STRING )
            {
            // InternalQuizDSL.g:382:4: (lv_password_5_0= RULE_STRING )
            // InternalQuizDSL.g:383:5: lv_password_5_0= RULE_STRING
            {
            lv_password_5_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_password_5_0, grammarAccess.getUserAccess().getPasswordSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserRule());
            					}
            					setWithLastConsumed(
            						current,
            						"password",
            						lv_password_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getUserAccess().getNameKeyword_6());
            		
            // InternalQuizDSL.g:403:3: ( (lv_fullName_7_0= RULE_STRING ) )
            // InternalQuizDSL.g:404:4: (lv_fullName_7_0= RULE_STRING )
            {
            // InternalQuizDSL.g:404:4: (lv_fullName_7_0= RULE_STRING )
            // InternalQuizDSL.g:405:5: lv_fullName_7_0= RULE_STRING
            {
            lv_fullName_7_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_fullName_7_0, grammarAccess.getUserAccess().getFullNameSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserRule());
            					}
            					setWithLastConsumed(
            						current,
            						"fullName",
            						lv_fullName_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:421:3: ( (lv_role_8_0= ruleUserRole ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=56 && LA2_0<=57)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalQuizDSL.g:422:4: (lv_role_8_0= ruleUserRole )
                    {
                    // InternalQuizDSL.g:422:4: (lv_role_8_0= ruleUserRole )
                    // InternalQuizDSL.g:423:5: lv_role_8_0= ruleUserRole
                    {

                    					newCompositeNode(grammarAccess.getUserAccess().getRoleUserRoleEnumRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_11);
                    lv_role_8_0=ruleUserRole();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getUserRule());
                    					}
                    					set(
                    						current,
                    						"role",
                    						lv_role_8_0,
                    						"org.example.quiz.QuizDSL.UserRole");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getUserAccess().getEndKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUser"


    // $ANTLR start "entryRuleQuizPlatform"
    // InternalQuizDSL.g:448:1: entryRuleQuizPlatform returns [EObject current=null] : iv_ruleQuizPlatform= ruleQuizPlatform EOF ;
    public final EObject entryRuleQuizPlatform() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuizPlatform = null;


        try {
            // InternalQuizDSL.g:448:53: (iv_ruleQuizPlatform= ruleQuizPlatform EOF )
            // InternalQuizDSL.g:449:2: iv_ruleQuizPlatform= ruleQuizPlatform EOF
            {
             newCompositeNode(grammarAccess.getQuizPlatformRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuizPlatform=ruleQuizPlatform();

            state._fsp--;

             current =iv_ruleQuizPlatform; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuizPlatform"


    // $ANTLR start "ruleQuizPlatform"
    // InternalQuizDSL.g:455:1: ruleQuizPlatform returns [EObject current=null] : (otherlv_0= 'platform' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'title' ( (lv_title_3_0= RULE_STRING ) ) otherlv_4= 'subtitle' ( (lv_subtitle_5_0= RULE_STRING ) ) otherlv_6= 'logo' ( (lv_logo_7_0= RULE_STRING ) ) otherlv_8= 'use_theme' ( (otherlv_9= RULE_ID ) ) ( (lv_quizzes_10_0= ruleQuiz ) )* otherlv_11= 'end' ) ;
    public final EObject ruleQuizPlatform() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token lv_subtitle_5_0=null;
        Token otherlv_6=null;
        Token lv_logo_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_quizzes_10_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:461:2: ( (otherlv_0= 'platform' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'title' ( (lv_title_3_0= RULE_STRING ) ) otherlv_4= 'subtitle' ( (lv_subtitle_5_0= RULE_STRING ) ) otherlv_6= 'logo' ( (lv_logo_7_0= RULE_STRING ) ) otherlv_8= 'use_theme' ( (otherlv_9= RULE_ID ) ) ( (lv_quizzes_10_0= ruleQuiz ) )* otherlv_11= 'end' ) )
            // InternalQuizDSL.g:462:2: (otherlv_0= 'platform' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'title' ( (lv_title_3_0= RULE_STRING ) ) otherlv_4= 'subtitle' ( (lv_subtitle_5_0= RULE_STRING ) ) otherlv_6= 'logo' ( (lv_logo_7_0= RULE_STRING ) ) otherlv_8= 'use_theme' ( (otherlv_9= RULE_ID ) ) ( (lv_quizzes_10_0= ruleQuiz ) )* otherlv_11= 'end' )
            {
            // InternalQuizDSL.g:462:2: (otherlv_0= 'platform' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'title' ( (lv_title_3_0= RULE_STRING ) ) otherlv_4= 'subtitle' ( (lv_subtitle_5_0= RULE_STRING ) ) otherlv_6= 'logo' ( (lv_logo_7_0= RULE_STRING ) ) otherlv_8= 'use_theme' ( (otherlv_9= RULE_ID ) ) ( (lv_quizzes_10_0= ruleQuiz ) )* otherlv_11= 'end' )
            // InternalQuizDSL.g:463:3: otherlv_0= 'platform' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'title' ( (lv_title_3_0= RULE_STRING ) ) otherlv_4= 'subtitle' ( (lv_subtitle_5_0= RULE_STRING ) ) otherlv_6= 'logo' ( (lv_logo_7_0= RULE_STRING ) ) otherlv_8= 'use_theme' ( (otherlv_9= RULE_ID ) ) ( (lv_quizzes_10_0= ruleQuiz ) )* otherlv_11= 'end'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getQuizPlatformAccess().getPlatformKeyword_0());
            		
            // InternalQuizDSL.g:467:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:468:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:468:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:469:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getQuizPlatformAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizPlatformRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getQuizPlatformAccess().getTitleKeyword_2());
            		
            // InternalQuizDSL.g:489:3: ( (lv_title_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:490:4: (lv_title_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:490:4: (lv_title_3_0= RULE_STRING )
            // InternalQuizDSL.g:491:5: lv_title_3_0= RULE_STRING
            {
            lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

            					newLeafNode(lv_title_3_0, grammarAccess.getQuizPlatformAccess().getTitleSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizPlatformRule());
            					}
            					setWithLastConsumed(
            						current,
            						"title",
            						lv_title_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getQuizPlatformAccess().getSubtitleKeyword_4());
            		
            // InternalQuizDSL.g:511:3: ( (lv_subtitle_5_0= RULE_STRING ) )
            // InternalQuizDSL.g:512:4: (lv_subtitle_5_0= RULE_STRING )
            {
            // InternalQuizDSL.g:512:4: (lv_subtitle_5_0= RULE_STRING )
            // InternalQuizDSL.g:513:5: lv_subtitle_5_0= RULE_STRING
            {
            lv_subtitle_5_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(lv_subtitle_5_0, grammarAccess.getQuizPlatformAccess().getSubtitleSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizPlatformRule());
            					}
            					setWithLastConsumed(
            						current,
            						"subtitle",
            						lv_subtitle_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getQuizPlatformAccess().getLogoKeyword_6());
            		
            // InternalQuizDSL.g:533:3: ( (lv_logo_7_0= RULE_STRING ) )
            // InternalQuizDSL.g:534:4: (lv_logo_7_0= RULE_STRING )
            {
            // InternalQuizDSL.g:534:4: (lv_logo_7_0= RULE_STRING )
            // InternalQuizDSL.g:535:5: lv_logo_7_0= RULE_STRING
            {
            lv_logo_7_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_logo_7_0, grammarAccess.getQuizPlatformAccess().getLogoSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizPlatformRule());
            					}
            					setWithLastConsumed(
            						current,
            						"logo",
            						lv_logo_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getQuizPlatformAccess().getUse_themeKeyword_8());
            		
            // InternalQuizDSL.g:555:3: ( (otherlv_9= RULE_ID ) )
            // InternalQuizDSL.g:556:4: (otherlv_9= RULE_ID )
            {
            // InternalQuizDSL.g:556:4: (otherlv_9= RULE_ID )
            // InternalQuizDSL.g:557:5: otherlv_9= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizPlatformRule());
            					}
            				
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(otherlv_9, grammarAccess.getQuizPlatformAccess().getThemeThemeCrossReference_9_0());
            				

            }


            }

            // InternalQuizDSL.g:568:3: ( (lv_quizzes_10_0= ruleQuiz ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==27) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalQuizDSL.g:569:4: (lv_quizzes_10_0= ruleQuiz )
            	    {
            	    // InternalQuizDSL.g:569:4: (lv_quizzes_10_0= ruleQuiz )
            	    // InternalQuizDSL.g:570:5: lv_quizzes_10_0= ruleQuiz
            	    {

            	    					newCompositeNode(grammarAccess.getQuizPlatformAccess().getQuizzesQuizParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_quizzes_10_0=ruleQuiz();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizPlatformRule());
            	    					}
            	    					add(
            	    						current,
            	    						"quizzes",
            	    						lv_quizzes_10_0,
            	    						"org.example.quiz.QuizDSL.Quiz");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getQuizPlatformAccess().getEndKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuizPlatform"


    // $ANTLR start "entryRuleQuiz"
    // InternalQuizDSL.g:595:1: entryRuleQuiz returns [EObject current=null] : iv_ruleQuiz= ruleQuiz EOF ;
    public final EObject entryRuleQuiz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuiz = null;


        try {
            // InternalQuizDSL.g:595:45: (iv_ruleQuiz= ruleQuiz EOF )
            // InternalQuizDSL.g:596:2: iv_ruleQuiz= ruleQuiz EOF
            {
             newCompositeNode(grammarAccess.getQuizRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuiz=ruleQuiz();

            state._fsp--;

             current =iv_ruleQuiz; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuiz"


    // $ANTLR start "ruleQuiz"
    // InternalQuizDSL.g:602:1: ruleQuiz returns [EObject current=null] : (otherlv_0= 'quiz' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'label' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'desc' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'icon' ( (lv_icon_7_0= RULE_STRING ) ) ( (lv_config_8_0= ruleQuizConfig ) ) ( (lv_questions_9_0= ruleQuestion ) )* otherlv_10= 'end' ) ;
    public final EObject ruleQuiz() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_label_3_0=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token otherlv_6=null;
        Token lv_icon_7_0=null;
        Token otherlv_10=null;
        EObject lv_config_8_0 = null;

        EObject lv_questions_9_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:608:2: ( (otherlv_0= 'quiz' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'label' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'desc' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'icon' ( (lv_icon_7_0= RULE_STRING ) ) ( (lv_config_8_0= ruleQuizConfig ) ) ( (lv_questions_9_0= ruleQuestion ) )* otherlv_10= 'end' ) )
            // InternalQuizDSL.g:609:2: (otherlv_0= 'quiz' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'label' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'desc' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'icon' ( (lv_icon_7_0= RULE_STRING ) ) ( (lv_config_8_0= ruleQuizConfig ) ) ( (lv_questions_9_0= ruleQuestion ) )* otherlv_10= 'end' )
            {
            // InternalQuizDSL.g:609:2: (otherlv_0= 'quiz' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'label' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'desc' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'icon' ( (lv_icon_7_0= RULE_STRING ) ) ( (lv_config_8_0= ruleQuizConfig ) ) ( (lv_questions_9_0= ruleQuestion ) )* otherlv_10= 'end' )
            // InternalQuizDSL.g:610:3: otherlv_0= 'quiz' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'label' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'desc' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'icon' ( (lv_icon_7_0= RULE_STRING ) ) ( (lv_config_8_0= ruleQuizConfig ) ) ( (lv_questions_9_0= ruleQuestion ) )* otherlv_10= 'end'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getQuizAccess().getQuizKeyword_0());
            		
            // InternalQuizDSL.g:614:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:615:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:615:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:616:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getQuizAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getQuizAccess().getLabelKeyword_2());
            		
            // InternalQuizDSL.g:636:3: ( (lv_label_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:637:4: (lv_label_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:637:4: (lv_label_3_0= RULE_STRING )
            // InternalQuizDSL.g:638:5: lv_label_3_0= RULE_STRING
            {
            lv_label_3_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_label_3_0, grammarAccess.getQuizAccess().getLabelSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizRule());
            					}
            					setWithLastConsumed(
            						current,
            						"label",
            						lv_label_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getQuizAccess().getDescKeyword_4());
            		
            // InternalQuizDSL.g:658:3: ( (lv_description_5_0= RULE_STRING ) )
            // InternalQuizDSL.g:659:4: (lv_description_5_0= RULE_STRING )
            {
            // InternalQuizDSL.g:659:4: (lv_description_5_0= RULE_STRING )
            // InternalQuizDSL.g:660:5: lv_description_5_0= RULE_STRING
            {
            lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            					newLeafNode(lv_description_5_0, grammarAccess.getQuizAccess().getDescriptionSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getQuizAccess().getIconKeyword_6());
            		
            // InternalQuizDSL.g:680:3: ( (lv_icon_7_0= RULE_STRING ) )
            // InternalQuizDSL.g:681:4: (lv_icon_7_0= RULE_STRING )
            {
            // InternalQuizDSL.g:681:4: (lv_icon_7_0= RULE_STRING )
            // InternalQuizDSL.g:682:5: lv_icon_7_0= RULE_STRING
            {
            lv_icon_7_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

            					newLeafNode(lv_icon_7_0, grammarAccess.getQuizAccess().getIconSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizRule());
            					}
            					setWithLastConsumed(
            						current,
            						"icon",
            						lv_icon_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:698:3: ( (lv_config_8_0= ruleQuizConfig ) )
            // InternalQuizDSL.g:699:4: (lv_config_8_0= ruleQuizConfig )
            {
            // InternalQuizDSL.g:699:4: (lv_config_8_0= ruleQuizConfig )
            // InternalQuizDSL.g:700:5: lv_config_8_0= ruleQuizConfig
            {

            					newCompositeNode(grammarAccess.getQuizAccess().getConfigQuizConfigParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_25);
            lv_config_8_0=ruleQuizConfig();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQuizRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_8_0,
            						"org.example.quiz.QuizDSL.QuizConfig");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQuizDSL.g:717:3: ( (lv_questions_9_0= ruleQuestion ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==37||(LA4_0>=42 && LA4_0<=43)||LA4_0==45) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalQuizDSL.g:718:4: (lv_questions_9_0= ruleQuestion )
            	    {
            	    // InternalQuizDSL.g:718:4: (lv_questions_9_0= ruleQuestion )
            	    // InternalQuizDSL.g:719:5: lv_questions_9_0= ruleQuestion
            	    {

            	    					newCompositeNode(grammarAccess.getQuizAccess().getQuestionsQuestionParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_questions_9_0=ruleQuestion();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizRule());
            	    					}
            	    					add(
            	    						current,
            	    						"questions",
            	    						lv_questions_9_0,
            	    						"org.example.quiz.QuizDSL.Question");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getQuizAccess().getEndKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuiz"


    // $ANTLR start "entryRuleQuizConfig"
    // InternalQuizDSL.g:744:1: entryRuleQuizConfig returns [EObject current=null] : iv_ruleQuizConfig= ruleQuizConfig EOF ;
    public final EObject entryRuleQuizConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuizConfig = null;


        try {
            // InternalQuizDSL.g:744:51: (iv_ruleQuizConfig= ruleQuizConfig EOF )
            // InternalQuizDSL.g:745:2: iv_ruleQuizConfig= ruleQuizConfig EOF
            {
             newCompositeNode(grammarAccess.getQuizConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuizConfig=ruleQuizConfig();

            state._fsp--;

             current =iv_ruleQuizConfig; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuizConfig"


    // $ANTLR start "ruleQuizConfig"
    // InternalQuizDSL.g:751:1: ruleQuizConfig returns [EObject current=null] : ( () ( (lv_access_1_0= ruleAccessType ) ) (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )? (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )? (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )? ( (lv_shuffleQuestions_9_0= 'shuffle' ) )? ( (lv_showResult_10_0= 'show_result' ) )? (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )? ) ;
    public final EObject ruleQuizConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_duration_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_startTime_6_0=null;
        Token otherlv_7=null;
        Token lv_endTime_8_0=null;
        Token lv_shuffleQuestions_9_0=null;
        Token lv_showResult_10_0=null;
        Token otherlv_11=null;
        Token lv_totalScore_12_0=null;
        Enumerator lv_access_1_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:757:2: ( ( () ( (lv_access_1_0= ruleAccessType ) ) (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )? (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )? (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )? ( (lv_shuffleQuestions_9_0= 'shuffle' ) )? ( (lv_showResult_10_0= 'show_result' ) )? (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )? ) )
            // InternalQuizDSL.g:758:2: ( () ( (lv_access_1_0= ruleAccessType ) ) (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )? (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )? (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )? ( (lv_shuffleQuestions_9_0= 'shuffle' ) )? ( (lv_showResult_10_0= 'show_result' ) )? (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )? )
            {
            // InternalQuizDSL.g:758:2: ( () ( (lv_access_1_0= ruleAccessType ) ) (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )? (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )? (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )? ( (lv_shuffleQuestions_9_0= 'shuffle' ) )? ( (lv_showResult_10_0= 'show_result' ) )? (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )? )
            // InternalQuizDSL.g:759:3: () ( (lv_access_1_0= ruleAccessType ) ) (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )? (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )? (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )? ( (lv_shuffleQuestions_9_0= 'shuffle' ) )? ( (lv_showResult_10_0= 'show_result' ) )? (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )?
            {
            // InternalQuizDSL.g:759:3: ()
            // InternalQuizDSL.g:760:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getQuizConfigAccess().getQuizConfigAction_0(),
            					current);
            			

            }

            // InternalQuizDSL.g:766:3: ( (lv_access_1_0= ruleAccessType ) )
            // InternalQuizDSL.g:767:4: (lv_access_1_0= ruleAccessType )
            {
            // InternalQuizDSL.g:767:4: (lv_access_1_0= ruleAccessType )
            // InternalQuizDSL.g:768:5: lv_access_1_0= ruleAccessType
            {

            					newCompositeNode(grammarAccess.getQuizConfigAccess().getAccessAccessTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_26);
            lv_access_1_0=ruleAccessType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQuizConfigRule());
            					}
            					set(
            						current,
            						"access",
            						lv_access_1_0,
            						"org.example.quiz.QuizDSL.AccessType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalQuizDSL.g:785:3: (otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalQuizDSL.g:786:4: otherlv_2= 'time' ( (lv_duration_3_0= RULE_INT ) ) otherlv_4= 'min'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_27); 

                    				newLeafNode(otherlv_2, grammarAccess.getQuizConfigAccess().getTimeKeyword_2_0());
                    			
                    // InternalQuizDSL.g:790:4: ( (lv_duration_3_0= RULE_INT ) )
                    // InternalQuizDSL.g:791:5: (lv_duration_3_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:791:5: (lv_duration_3_0= RULE_INT )
                    // InternalQuizDSL.g:792:6: lv_duration_3_0= RULE_INT
                    {
                    lv_duration_3_0=(Token)match(input,RULE_INT,FOLLOW_28); 

                    						newLeafNode(lv_duration_3_0, grammarAccess.getQuizConfigAccess().getDurationINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuizConfigRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"duration",
                    							lv_duration_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,32,FOLLOW_29); 

                    				newLeafNode(otherlv_4, grammarAccess.getQuizConfigAccess().getMinKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalQuizDSL.g:813:3: (otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==33) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalQuizDSL.g:814:4: otherlv_5= 'start' ( (lv_startTime_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getQuizConfigAccess().getStartKeyword_3_0());
                    			
                    // InternalQuizDSL.g:818:4: ( (lv_startTime_6_0= RULE_STRING ) )
                    // InternalQuizDSL.g:819:5: (lv_startTime_6_0= RULE_STRING )
                    {
                    // InternalQuizDSL.g:819:5: (lv_startTime_6_0= RULE_STRING )
                    // InternalQuizDSL.g:820:6: lv_startTime_6_0= RULE_STRING
                    {
                    lv_startTime_6_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

                    						newLeafNode(lv_startTime_6_0, grammarAccess.getQuizConfigAccess().getStartTimeSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuizConfigRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"startTime",
                    							lv_startTime_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalQuizDSL.g:837:3: (otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_STRING) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalQuizDSL.g:838:4: otherlv_7= 'end' ( (lv_endTime_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getQuizConfigAccess().getEndKeyword_4_0());
                    			
                    // InternalQuizDSL.g:842:4: ( (lv_endTime_8_0= RULE_STRING ) )
                    // InternalQuizDSL.g:843:5: (lv_endTime_8_0= RULE_STRING )
                    {
                    // InternalQuizDSL.g:843:5: (lv_endTime_8_0= RULE_STRING )
                    // InternalQuizDSL.g:844:6: lv_endTime_8_0= RULE_STRING
                    {
                    lv_endTime_8_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

                    						newLeafNode(lv_endTime_8_0, grammarAccess.getQuizConfigAccess().getEndTimeSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuizConfigRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"endTime",
                    							lv_endTime_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalQuizDSL.g:861:3: ( (lv_shuffleQuestions_9_0= 'shuffle' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==34) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalQuizDSL.g:862:4: (lv_shuffleQuestions_9_0= 'shuffle' )
                    {
                    // InternalQuizDSL.g:862:4: (lv_shuffleQuestions_9_0= 'shuffle' )
                    // InternalQuizDSL.g:863:5: lv_shuffleQuestions_9_0= 'shuffle'
                    {
                    lv_shuffleQuestions_9_0=(Token)match(input,34,FOLLOW_32); 

                    					newLeafNode(lv_shuffleQuestions_9_0, grammarAccess.getQuizConfigAccess().getShuffleQuestionsShuffleKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQuizConfigRule());
                    					}
                    					setWithLastConsumed(current, "shuffleQuestions", lv_shuffleQuestions_9_0 != null, "shuffle");
                    				

                    }


                    }
                    break;

            }

            // InternalQuizDSL.g:875:3: ( (lv_showResult_10_0= 'show_result' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==35) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalQuizDSL.g:876:4: (lv_showResult_10_0= 'show_result' )
                    {
                    // InternalQuizDSL.g:876:4: (lv_showResult_10_0= 'show_result' )
                    // InternalQuizDSL.g:877:5: lv_showResult_10_0= 'show_result'
                    {
                    lv_showResult_10_0=(Token)match(input,35,FOLLOW_33); 

                    					newLeafNode(lv_showResult_10_0, grammarAccess.getQuizConfigAccess().getShowResultShow_resultKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQuizConfigRule());
                    					}
                    					setWithLastConsumed(current, "showResult", lv_showResult_10_0 != null, "show_result");
                    				

                    }


                    }
                    break;

            }

            // InternalQuizDSL.g:889:3: (otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==36) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQuizDSL.g:890:4: otherlv_11= 'score' ( (lv_totalScore_12_0= RULE_INT ) )
                    {
                    otherlv_11=(Token)match(input,36,FOLLOW_27); 

                    				newLeafNode(otherlv_11, grammarAccess.getQuizConfigAccess().getScoreKeyword_7_0());
                    			
                    // InternalQuizDSL.g:894:4: ( (lv_totalScore_12_0= RULE_INT ) )
                    // InternalQuizDSL.g:895:5: (lv_totalScore_12_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:895:5: (lv_totalScore_12_0= RULE_INT )
                    // InternalQuizDSL.g:896:6: lv_totalScore_12_0= RULE_INT
                    {
                    lv_totalScore_12_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_totalScore_12_0, grammarAccess.getQuizConfigAccess().getTotalScoreINTTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuizConfigRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"totalScore",
                    							lv_totalScore_12_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuizConfig"


    // $ANTLR start "entryRuleQuestion"
    // InternalQuizDSL.g:917:1: entryRuleQuestion returns [EObject current=null] : iv_ruleQuestion= ruleQuestion EOF ;
    public final EObject entryRuleQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuestion = null;


        try {
            // InternalQuizDSL.g:917:49: (iv_ruleQuestion= ruleQuestion EOF )
            // InternalQuizDSL.g:918:2: iv_ruleQuestion= ruleQuestion EOF
            {
             newCompositeNode(grammarAccess.getQuestionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuestion=ruleQuestion();

            state._fsp--;

             current =iv_ruleQuestion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuestion"


    // $ANTLR start "ruleQuestion"
    // InternalQuizDSL.g:924:1: ruleQuestion returns [EObject current=null] : (this_SingleChoiceQuestion_0= ruleSingleChoiceQuestion | this_MultipleChoiceQuestion_1= ruleMultipleChoiceQuestion | this_TrueFalseQuestion_2= ruleTrueFalseQuestion | this_DescriptiveQuestion_3= ruleDescriptiveQuestion ) ;
    public final EObject ruleQuestion() throws RecognitionException {
        EObject current = null;

        EObject this_SingleChoiceQuestion_0 = null;

        EObject this_MultipleChoiceQuestion_1 = null;

        EObject this_TrueFalseQuestion_2 = null;

        EObject this_DescriptiveQuestion_3 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:930:2: ( (this_SingleChoiceQuestion_0= ruleSingleChoiceQuestion | this_MultipleChoiceQuestion_1= ruleMultipleChoiceQuestion | this_TrueFalseQuestion_2= ruleTrueFalseQuestion | this_DescriptiveQuestion_3= ruleDescriptiveQuestion ) )
            // InternalQuizDSL.g:931:2: (this_SingleChoiceQuestion_0= ruleSingleChoiceQuestion | this_MultipleChoiceQuestion_1= ruleMultipleChoiceQuestion | this_TrueFalseQuestion_2= ruleTrueFalseQuestion | this_DescriptiveQuestion_3= ruleDescriptiveQuestion )
            {
            // InternalQuizDSL.g:931:2: (this_SingleChoiceQuestion_0= ruleSingleChoiceQuestion | this_MultipleChoiceQuestion_1= ruleMultipleChoiceQuestion | this_TrueFalseQuestion_2= ruleTrueFalseQuestion | this_DescriptiveQuestion_3= ruleDescriptiveQuestion )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt11=1;
                }
                break;
            case 42:
                {
                alt11=2;
                }
                break;
            case 43:
                {
                alt11=3;
                }
                break;
            case 45:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalQuizDSL.g:932:3: this_SingleChoiceQuestion_0= ruleSingleChoiceQuestion
                    {

                    			newCompositeNode(grammarAccess.getQuestionAccess().getSingleChoiceQuestionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleChoiceQuestion_0=ruleSingleChoiceQuestion();

                    state._fsp--;


                    			current = this_SingleChoiceQuestion_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:941:3: this_MultipleChoiceQuestion_1= ruleMultipleChoiceQuestion
                    {

                    			newCompositeNode(grammarAccess.getQuestionAccess().getMultipleChoiceQuestionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MultipleChoiceQuestion_1=ruleMultipleChoiceQuestion();

                    state._fsp--;


                    			current = this_MultipleChoiceQuestion_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalQuizDSL.g:950:3: this_TrueFalseQuestion_2= ruleTrueFalseQuestion
                    {

                    			newCompositeNode(grammarAccess.getQuestionAccess().getTrueFalseQuestionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrueFalseQuestion_2=ruleTrueFalseQuestion();

                    state._fsp--;


                    			current = this_TrueFalseQuestion_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalQuizDSL.g:959:3: this_DescriptiveQuestion_3= ruleDescriptiveQuestion
                    {

                    			newCompositeNode(grammarAccess.getQuestionAccess().getDescriptiveQuestionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DescriptiveQuestion_3=ruleDescriptiveQuestion();

                    state._fsp--;


                    			current = this_DescriptiveQuestion_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuestion"


    // $ANTLR start "entryRuleSingleChoiceQuestion"
    // InternalQuizDSL.g:971:1: entryRuleSingleChoiceQuestion returns [EObject current=null] : iv_ruleSingleChoiceQuestion= ruleSingleChoiceQuestion EOF ;
    public final EObject entryRuleSingleChoiceQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleChoiceQuestion = null;


        try {
            // InternalQuizDSL.g:971:61: (iv_ruleSingleChoiceQuestion= ruleSingleChoiceQuestion EOF )
            // InternalQuizDSL.g:972:2: iv_ruleSingleChoiceQuestion= ruleSingleChoiceQuestion EOF
            {
             newCompositeNode(grammarAccess.getSingleChoiceQuestionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleChoiceQuestion=ruleSingleChoiceQuestion();

            state._fsp--;

             current =iv_ruleSingleChoiceQuestion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleChoiceQuestion"


    // $ANTLR start "ruleSingleChoiceQuestion"
    // InternalQuizDSL.g:978:1: ruleSingleChoiceQuestion returns [EObject current=null] : (otherlv_0= 'single_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )? otherlv_8= 'options' ( (lv_options_9_0= ruleOption ) )+ otherlv_10= 'correct' ( (otherlv_11= RULE_ID ) ) otherlv_12= 'end' ) ;
    public final EObject ruleSingleChoiceQuestion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_text_3_0=null;
        Token otherlv_4=null;
        Token lv_score_5_0=null;
        Token otherlv_6=null;
        Token lv_mediaUrl_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_options_9_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:984:2: ( (otherlv_0= 'single_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )? otherlv_8= 'options' ( (lv_options_9_0= ruleOption ) )+ otherlv_10= 'correct' ( (otherlv_11= RULE_ID ) ) otherlv_12= 'end' ) )
            // InternalQuizDSL.g:985:2: (otherlv_0= 'single_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )? otherlv_8= 'options' ( (lv_options_9_0= ruleOption ) )+ otherlv_10= 'correct' ( (otherlv_11= RULE_ID ) ) otherlv_12= 'end' )
            {
            // InternalQuizDSL.g:985:2: (otherlv_0= 'single_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )? otherlv_8= 'options' ( (lv_options_9_0= ruleOption ) )+ otherlv_10= 'correct' ( (otherlv_11= RULE_ID ) ) otherlv_12= 'end' )
            // InternalQuizDSL.g:986:3: otherlv_0= 'single_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )? otherlv_8= 'options' ( (lv_options_9_0= ruleOption ) )+ otherlv_10= 'correct' ( (otherlv_11= RULE_ID ) ) otherlv_12= 'end'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSingleChoiceQuestionAccess().getSingle_choiceKeyword_0());
            		
            // InternalQuizDSL.g:990:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:991:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:991:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:992:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSingleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleChoiceQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSingleChoiceQuestionAccess().getTextKeyword_2());
            		
            // InternalQuizDSL.g:1012:3: ( (lv_text_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:1013:4: (lv_text_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1013:4: (lv_text_3_0= RULE_STRING )
            // InternalQuizDSL.g:1014:5: lv_text_3_0= RULE_STRING
            {
            lv_text_3_0=(Token)match(input,RULE_STRING,FOLLOW_34); 

            					newLeafNode(lv_text_3_0, grammarAccess.getSingleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleChoiceQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:1030:3: (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==38) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalQuizDSL.g:1031:4: otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getSingleChoiceQuestionAccess().getValKeyword_4_0());
                    			
                    // InternalQuizDSL.g:1035:4: ( (lv_score_5_0= RULE_INT ) )
                    // InternalQuizDSL.g:1036:5: (lv_score_5_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:1036:5: (lv_score_5_0= RULE_INT )
                    // InternalQuizDSL.g:1037:6: lv_score_5_0= RULE_INT
                    {
                    lv_score_5_0=(Token)match(input,RULE_INT,FOLLOW_35); 

                    						newLeafNode(lv_score_5_0, grammarAccess.getSingleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSingleChoiceQuestionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"score",
                    							lv_score_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalQuizDSL.g:1054:3: (otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalQuizDSL.g:1055:4: otherlv_6= 'media' ( (lv_mediaUrl_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,39,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getSingleChoiceQuestionAccess().getMediaKeyword_5_0());
                    			
                    // InternalQuizDSL.g:1059:4: ( (lv_mediaUrl_7_0= RULE_STRING ) )
                    // InternalQuizDSL.g:1060:5: (lv_mediaUrl_7_0= RULE_STRING )
                    {
                    // InternalQuizDSL.g:1060:5: (lv_mediaUrl_7_0= RULE_STRING )
                    // InternalQuizDSL.g:1061:6: lv_mediaUrl_7_0= RULE_STRING
                    {
                    lv_mediaUrl_7_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

                    						newLeafNode(lv_mediaUrl_7_0, grammarAccess.getSingleChoiceQuestionAccess().getMediaUrlSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSingleChoiceQuestionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"mediaUrl",
                    							lv_mediaUrl_7_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getSingleChoiceQuestionAccess().getOptionsKeyword_6());
            		
            // InternalQuizDSL.g:1082:3: ( (lv_options_9_0= ruleOption ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalQuizDSL.g:1083:4: (lv_options_9_0= ruleOption )
            	    {
            	    // InternalQuizDSL.g:1083:4: (lv_options_9_0= ruleOption )
            	    // InternalQuizDSL.g:1084:5: lv_options_9_0= ruleOption
            	    {

            	    					newCompositeNode(grammarAccess.getSingleChoiceQuestionAccess().getOptionsOptionParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_options_9_0=ruleOption();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSingleChoiceQuestionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"options",
            	    						lv_options_9_0,
            	    						"org.example.quiz.QuizDSL.Option");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            otherlv_10=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getSingleChoiceQuestionAccess().getCorrectKeyword_8());
            		
            // InternalQuizDSL.g:1105:3: ( (otherlv_11= RULE_ID ) )
            // InternalQuizDSL.g:1106:4: (otherlv_11= RULE_ID )
            {
            // InternalQuizDSL.g:1106:4: (otherlv_11= RULE_ID )
            // InternalQuizDSL.g:1107:5: otherlv_11= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleChoiceQuestionRule());
            					}
            				
            otherlv_11=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_11, grammarAccess.getSingleChoiceQuestionAccess().getCorrectOptionOptionCrossReference_9_0());
            				

            }


            }

            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getSingleChoiceQuestionAccess().getEndKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleChoiceQuestion"


    // $ANTLR start "entryRuleMultipleChoiceQuestion"
    // InternalQuizDSL.g:1126:1: entryRuleMultipleChoiceQuestion returns [EObject current=null] : iv_ruleMultipleChoiceQuestion= ruleMultipleChoiceQuestion EOF ;
    public final EObject entryRuleMultipleChoiceQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultipleChoiceQuestion = null;


        try {
            // InternalQuizDSL.g:1126:63: (iv_ruleMultipleChoiceQuestion= ruleMultipleChoiceQuestion EOF )
            // InternalQuizDSL.g:1127:2: iv_ruleMultipleChoiceQuestion= ruleMultipleChoiceQuestion EOF
            {
             newCompositeNode(grammarAccess.getMultipleChoiceQuestionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultipleChoiceQuestion=ruleMultipleChoiceQuestion();

            state._fsp--;

             current =iv_ruleMultipleChoiceQuestion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultipleChoiceQuestion"


    // $ANTLR start "ruleMultipleChoiceQuestion"
    // InternalQuizDSL.g:1133:1: ruleMultipleChoiceQuestion returns [EObject current=null] : (otherlv_0= 'multi_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'options' ( (lv_options_7_0= ruleOption ) )+ otherlv_8= 'end' ) ;
    public final EObject ruleMultipleChoiceQuestion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_text_3_0=null;
        Token otherlv_4=null;
        Token lv_score_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_options_7_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:1139:2: ( (otherlv_0= 'multi_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'options' ( (lv_options_7_0= ruleOption ) )+ otherlv_8= 'end' ) )
            // InternalQuizDSL.g:1140:2: (otherlv_0= 'multi_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'options' ( (lv_options_7_0= ruleOption ) )+ otherlv_8= 'end' )
            {
            // InternalQuizDSL.g:1140:2: (otherlv_0= 'multi_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'options' ( (lv_options_7_0= ruleOption ) )+ otherlv_8= 'end' )
            // InternalQuizDSL.g:1141:3: otherlv_0= 'multi_choice' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'options' ( (lv_options_7_0= ruleOption ) )+ otherlv_8= 'end'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMultipleChoiceQuestionAccess().getMulti_choiceKeyword_0());
            		
            // InternalQuizDSL.g:1145:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:1146:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:1146:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:1147:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMultipleChoiceQuestionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMultipleChoiceQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getMultipleChoiceQuestionAccess().getTextKeyword_2());
            		
            // InternalQuizDSL.g:1167:3: ( (lv_text_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:1168:4: (lv_text_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1168:4: (lv_text_3_0= RULE_STRING )
            // InternalQuizDSL.g:1169:5: lv_text_3_0= RULE_STRING
            {
            lv_text_3_0=(Token)match(input,RULE_STRING,FOLLOW_38); 

            					newLeafNode(lv_text_3_0, grammarAccess.getMultipleChoiceQuestionAccess().getTextSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMultipleChoiceQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:1185:3: (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalQuizDSL.g:1186:4: otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getMultipleChoiceQuestionAccess().getValKeyword_4_0());
                    			
                    // InternalQuizDSL.g:1190:4: ( (lv_score_5_0= RULE_INT ) )
                    // InternalQuizDSL.g:1191:5: (lv_score_5_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:1191:5: (lv_score_5_0= RULE_INT )
                    // InternalQuizDSL.g:1192:6: lv_score_5_0= RULE_INT
                    {
                    lv_score_5_0=(Token)match(input,RULE_INT,FOLLOW_36); 

                    						newLeafNode(lv_score_5_0, grammarAccess.getMultipleChoiceQuestionAccess().getScoreINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMultipleChoiceQuestionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"score",
                    							lv_score_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getMultipleChoiceQuestionAccess().getOptionsKeyword_5());
            		
            // InternalQuizDSL.g:1213:3: ( (lv_options_7_0= ruleOption ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalQuizDSL.g:1214:4: (lv_options_7_0= ruleOption )
            	    {
            	    // InternalQuizDSL.g:1214:4: (lv_options_7_0= ruleOption )
            	    // InternalQuizDSL.g:1215:5: lv_options_7_0= ruleOption
            	    {

            	    					newCompositeNode(grammarAccess.getMultipleChoiceQuestionAccess().getOptionsOptionParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_options_7_0=ruleOption();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMultipleChoiceQuestionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"options",
            	    						lv_options_7_0,
            	    						"org.example.quiz.QuizDSL.Option");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getMultipleChoiceQuestionAccess().getEndKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultipleChoiceQuestion"


    // $ANTLR start "entryRuleTrueFalseQuestion"
    // InternalQuizDSL.g:1240:1: entryRuleTrueFalseQuestion returns [EObject current=null] : iv_ruleTrueFalseQuestion= ruleTrueFalseQuestion EOF ;
    public final EObject entryRuleTrueFalseQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueFalseQuestion = null;


        try {
            // InternalQuizDSL.g:1240:58: (iv_ruleTrueFalseQuestion= ruleTrueFalseQuestion EOF )
            // InternalQuizDSL.g:1241:2: iv_ruleTrueFalseQuestion= ruleTrueFalseQuestion EOF
            {
             newCompositeNode(grammarAccess.getTrueFalseQuestionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrueFalseQuestion=ruleTrueFalseQuestion();

            state._fsp--;

             current =iv_ruleTrueFalseQuestion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrueFalseQuestion"


    // $ANTLR start "ruleTrueFalseQuestion"
    // InternalQuizDSL.g:1247:1: ruleTrueFalseQuestion returns [EObject current=null] : (otherlv_0= 'true_false' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'answer' ( (lv_isTrue_7_0= ruleEBoolean ) ) otherlv_8= 'end' ) ;
    public final EObject ruleTrueFalseQuestion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_text_3_0=null;
        Token otherlv_4=null;
        Token lv_score_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_isTrue_7_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:1253:2: ( (otherlv_0= 'true_false' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'answer' ( (lv_isTrue_7_0= ruleEBoolean ) ) otherlv_8= 'end' ) )
            // InternalQuizDSL.g:1254:2: (otherlv_0= 'true_false' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'answer' ( (lv_isTrue_7_0= ruleEBoolean ) ) otherlv_8= 'end' )
            {
            // InternalQuizDSL.g:1254:2: (otherlv_0= 'true_false' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'answer' ( (lv_isTrue_7_0= ruleEBoolean ) ) otherlv_8= 'end' )
            // InternalQuizDSL.g:1255:3: otherlv_0= 'true_false' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'answer' ( (lv_isTrue_7_0= ruleEBoolean ) ) otherlv_8= 'end'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTrueFalseQuestionAccess().getTrue_falseKeyword_0());
            		
            // InternalQuizDSL.g:1259:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:1260:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:1260:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:1261:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTrueFalseQuestionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTrueFalseQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTrueFalseQuestionAccess().getTextKeyword_2());
            		
            // InternalQuizDSL.g:1281:3: ( (lv_text_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:1282:4: (lv_text_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1282:4: (lv_text_3_0= RULE_STRING )
            // InternalQuizDSL.g:1283:5: lv_text_3_0= RULE_STRING
            {
            lv_text_3_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

            					newLeafNode(lv_text_3_0, grammarAccess.getTrueFalseQuestionAccess().getTextSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTrueFalseQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:1299:3: (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalQuizDSL.g:1300:4: otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getTrueFalseQuestionAccess().getValKeyword_4_0());
                    			
                    // InternalQuizDSL.g:1304:4: ( (lv_score_5_0= RULE_INT ) )
                    // InternalQuizDSL.g:1305:5: (lv_score_5_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:1305:5: (lv_score_5_0= RULE_INT )
                    // InternalQuizDSL.g:1306:6: lv_score_5_0= RULE_INT
                    {
                    lv_score_5_0=(Token)match(input,RULE_INT,FOLLOW_41); 

                    						newLeafNode(lv_score_5_0, grammarAccess.getTrueFalseQuestionAccess().getScoreINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTrueFalseQuestionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"score",
                    							lv_score_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,44,FOLLOW_42); 

            			newLeafNode(otherlv_6, grammarAccess.getTrueFalseQuestionAccess().getAnswerKeyword_5());
            		
            // InternalQuizDSL.g:1327:3: ( (lv_isTrue_7_0= ruleEBoolean ) )
            // InternalQuizDSL.g:1328:4: (lv_isTrue_7_0= ruleEBoolean )
            {
            // InternalQuizDSL.g:1328:4: (lv_isTrue_7_0= ruleEBoolean )
            // InternalQuizDSL.g:1329:5: lv_isTrue_7_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getTrueFalseQuestionAccess().getIsTrueEBooleanParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_11);
            lv_isTrue_7_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTrueFalseQuestionRule());
            					}
            					set(
            						current,
            						"isTrue",
            						lv_isTrue_7_0,
            						"org.example.quiz.QuizDSL.EBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTrueFalseQuestionAccess().getEndKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrueFalseQuestion"


    // $ANTLR start "entryRuleDescriptiveQuestion"
    // InternalQuizDSL.g:1354:1: entryRuleDescriptiveQuestion returns [EObject current=null] : iv_ruleDescriptiveQuestion= ruleDescriptiveQuestion EOF ;
    public final EObject entryRuleDescriptiveQuestion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptiveQuestion = null;


        try {
            // InternalQuizDSL.g:1354:60: (iv_ruleDescriptiveQuestion= ruleDescriptiveQuestion EOF )
            // InternalQuizDSL.g:1355:2: iv_ruleDescriptiveQuestion= ruleDescriptiveQuestion EOF
            {
             newCompositeNode(grammarAccess.getDescriptiveQuestionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescriptiveQuestion=ruleDescriptiveQuestion();

            state._fsp--;

             current =iv_ruleDescriptiveQuestion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptiveQuestion"


    // $ANTLR start "ruleDescriptiveQuestion"
    // InternalQuizDSL.g:1361:1: ruleDescriptiveQuestion returns [EObject current=null] : (otherlv_0= 'descriptive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'end' ) ;
    public final EObject ruleDescriptiveQuestion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_text_3_0=null;
        Token otherlv_4=null;
        Token lv_score_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:1367:2: ( (otherlv_0= 'descriptive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'end' ) )
            // InternalQuizDSL.g:1368:2: (otherlv_0= 'descriptive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'end' )
            {
            // InternalQuizDSL.g:1368:2: (otherlv_0= 'descriptive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'end' )
            // InternalQuizDSL.g:1369:3: otherlv_0= 'descriptive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'text' ( (lv_text_3_0= RULE_STRING ) ) (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )? otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptiveQuestionAccess().getDescriptiveKeyword_0());
            		
            // InternalQuizDSL.g:1373:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:1374:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:1374:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:1375:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDescriptiveQuestionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptiveQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDescriptiveQuestionAccess().getTextKeyword_2());
            		
            // InternalQuizDSL.g:1395:3: ( (lv_text_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:1396:4: (lv_text_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1396:4: (lv_text_3_0= RULE_STRING )
            // InternalQuizDSL.g:1397:5: lv_text_3_0= RULE_STRING
            {
            lv_text_3_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

            					newLeafNode(lv_text_3_0, grammarAccess.getDescriptiveQuestionAccess().getTextSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptiveQuestionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalQuizDSL.g:1413:3: (otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalQuizDSL.g:1414:4: otherlv_4= 'val' ( (lv_score_5_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getDescriptiveQuestionAccess().getValKeyword_4_0());
                    			
                    // InternalQuizDSL.g:1418:4: ( (lv_score_5_0= RULE_INT ) )
                    // InternalQuizDSL.g:1419:5: (lv_score_5_0= RULE_INT )
                    {
                    // InternalQuizDSL.g:1419:5: (lv_score_5_0= RULE_INT )
                    // InternalQuizDSL.g:1420:6: lv_score_5_0= RULE_INT
                    {
                    lv_score_5_0=(Token)match(input,RULE_INT,FOLLOW_11); 

                    						newLeafNode(lv_score_5_0, grammarAccess.getDescriptiveQuestionAccess().getScoreINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDescriptiveQuestionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"score",
                    							lv_score_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getDescriptiveQuestionAccess().getEndKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptiveQuestion"


    // $ANTLR start "entryRuleOption"
    // InternalQuizDSL.g:1445:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalQuizDSL.g:1445:47: (iv_ruleOption= ruleOption EOF )
            // InternalQuizDSL.g:1446:2: iv_ruleOption= ruleOption EOF
            {
             newCompositeNode(grammarAccess.getOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOption=ruleOption();

            state._fsp--;

             current =iv_ruleOption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalQuizDSL.g:1452:1: ruleOption returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '->' ( (lv_text_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleOption() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_text_2_0=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:1458:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '->' ( (lv_text_2_0= RULE_STRING ) ) ) )
            // InternalQuizDSL.g:1459:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '->' ( (lv_text_2_0= RULE_STRING ) ) )
            {
            // InternalQuizDSL.g:1459:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '->' ( (lv_text_2_0= RULE_STRING ) ) )
            // InternalQuizDSL.g:1460:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '->' ( (lv_text_2_0= RULE_STRING ) )
            {
            // InternalQuizDSL.g:1460:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalQuizDSL.g:1461:4: (lv_name_0_0= RULE_ID )
            {
            // InternalQuizDSL.g:1461:4: (lv_name_0_0= RULE_ID )
            // InternalQuizDSL.g:1462:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_44); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOptionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,46,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getOptionAccess().getHyphenMinusGreaterThanSignKeyword_1());
            		
            // InternalQuizDSL.g:1482:3: ( (lv_text_2_0= RULE_STRING ) )
            // InternalQuizDSL.g:1483:4: (lv_text_2_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1483:4: (lv_text_2_0= RULE_STRING )
            // InternalQuizDSL.g:1484:5: lv_text_2_0= RULE_STRING
            {
            lv_text_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_text_2_0, grammarAccess.getOptionAccess().getTextSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRuleEBoolean"
    // InternalQuizDSL.g:1504:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalQuizDSL.g:1504:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalQuizDSL.g:1505:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalQuizDSL.g:1511:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:1517:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalQuizDSL.g:1518:2: (kw= 'true' | kw= 'false' )
            {
            // InternalQuizDSL.g:1518:2: (kw= 'true' | kw= 'false' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            else if ( (LA19_0==48) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalQuizDSL.g:1519:3: kw= 'true'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:1525:3: kw= 'false'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleQuizResult"
    // InternalQuizDSL.g:1534:1: entryRuleQuizResult returns [EObject current=null] : iv_ruleQuizResult= ruleQuizResult EOF ;
    public final EObject entryRuleQuizResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuizResult = null;


        try {
            // InternalQuizDSL.g:1534:51: (iv_ruleQuizResult= ruleQuizResult EOF )
            // InternalQuizDSL.g:1535:2: iv_ruleQuizResult= ruleQuizResult EOF
            {
             newCompositeNode(grammarAccess.getQuizResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuizResult=ruleQuizResult();

            state._fsp--;

             current =iv_ruleQuizResult; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuizResult"


    // $ANTLR start "ruleQuizResult"
    // InternalQuizDSL.g:1541:1: ruleQuizResult returns [EObject current=null] : (otherlv_0= 'result' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'user' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'quiz' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'score' ( (lv_finalScore_7_0= RULE_INT ) ) otherlv_8= 'responses' otherlv_9= '{' ( (lv_responses_10_0= ruleUserResponse ) )+ otherlv_11= '}' otherlv_12= 'end' ) ;
    public final EObject ruleQuizResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_finalScore_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_responses_10_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:1547:2: ( (otherlv_0= 'result' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'user' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'quiz' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'score' ( (lv_finalScore_7_0= RULE_INT ) ) otherlv_8= 'responses' otherlv_9= '{' ( (lv_responses_10_0= ruleUserResponse ) )+ otherlv_11= '}' otherlv_12= 'end' ) )
            // InternalQuizDSL.g:1548:2: (otherlv_0= 'result' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'user' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'quiz' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'score' ( (lv_finalScore_7_0= RULE_INT ) ) otherlv_8= 'responses' otherlv_9= '{' ( (lv_responses_10_0= ruleUserResponse ) )+ otherlv_11= '}' otherlv_12= 'end' )
            {
            // InternalQuizDSL.g:1548:2: (otherlv_0= 'result' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'user' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'quiz' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'score' ( (lv_finalScore_7_0= RULE_INT ) ) otherlv_8= 'responses' otherlv_9= '{' ( (lv_responses_10_0= ruleUserResponse ) )+ otherlv_11= '}' otherlv_12= 'end' )
            // InternalQuizDSL.g:1549:3: otherlv_0= 'result' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'user' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'quiz' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'score' ( (lv_finalScore_7_0= RULE_INT ) ) otherlv_8= 'responses' otherlv_9= '{' ( (lv_responses_10_0= ruleUserResponse ) )+ otherlv_11= '}' otherlv_12= 'end'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getQuizResultAccess().getResultKeyword_0());
            		
            // InternalQuizDSL.g:1553:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalQuizDSL.g:1554:4: (lv_name_1_0= RULE_ID )
            {
            // InternalQuizDSL.g:1554:4: (lv_name_1_0= RULE_ID )
            // InternalQuizDSL.g:1555:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(lv_name_1_0, grammarAccess.getQuizResultAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizResultRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getQuizResultAccess().getUserKeyword_2());
            		
            // InternalQuizDSL.g:1575:3: ( (otherlv_3= RULE_ID ) )
            // InternalQuizDSL.g:1576:4: (otherlv_3= RULE_ID )
            {
            // InternalQuizDSL.g:1576:4: (otherlv_3= RULE_ID )
            // InternalQuizDSL.g:1577:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizResultRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(otherlv_3, grammarAccess.getQuizResultAccess().getUserUserCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getQuizResultAccess().getQuizKeyword_4());
            		
            // InternalQuizDSL.g:1592:3: ( (otherlv_5= RULE_ID ) )
            // InternalQuizDSL.g:1593:4: (otherlv_5= RULE_ID )
            {
            // InternalQuizDSL.g:1593:4: (otherlv_5= RULE_ID )
            // InternalQuizDSL.g:1594:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizResultRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(otherlv_5, grammarAccess.getQuizResultAccess().getQuizQuizCrossReference_5_0());
            				

            }


            }

            otherlv_6=(Token)match(input,36,FOLLOW_27); 

            			newLeafNode(otherlv_6, grammarAccess.getQuizResultAccess().getScoreKeyword_6());
            		
            // InternalQuizDSL.g:1609:3: ( (lv_finalScore_7_0= RULE_INT ) )
            // InternalQuizDSL.g:1610:4: (lv_finalScore_7_0= RULE_INT )
            {
            // InternalQuizDSL.g:1610:4: (lv_finalScore_7_0= RULE_INT )
            // InternalQuizDSL.g:1611:5: lv_finalScore_7_0= RULE_INT
            {
            lv_finalScore_7_0=(Token)match(input,RULE_INT,FOLLOW_48); 

            					newLeafNode(lv_finalScore_7_0, grammarAccess.getQuizResultAccess().getFinalScoreINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuizResultRule());
            					}
            					setWithLastConsumed(
            						current,
            						"finalScore",
            						lv_finalScore_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,50,FOLLOW_49); 

            			newLeafNode(otherlv_8, grammarAccess.getQuizResultAccess().getResponsesKeyword_8());
            		
            otherlv_9=(Token)match(input,51,FOLLOW_50); 

            			newLeafNode(otherlv_9, grammarAccess.getQuizResultAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalQuizDSL.g:1635:3: ( (lv_responses_10_0= ruleUserResponse ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==53) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalQuizDSL.g:1636:4: (lv_responses_10_0= ruleUserResponse )
            	    {
            	    // InternalQuizDSL.g:1636:4: (lv_responses_10_0= ruleUserResponse )
            	    // InternalQuizDSL.g:1637:5: lv_responses_10_0= ruleUserResponse
            	    {

            	    					newCompositeNode(grammarAccess.getQuizResultAccess().getResponsesUserResponseParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_51);
            	    lv_responses_10_0=ruleUserResponse();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQuizResultRule());
            	    					}
            	    					add(
            	    						current,
            	    						"responses",
            	    						lv_responses_10_0,
            	    						"org.example.quiz.QuizDSL.UserResponse");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            otherlv_11=(Token)match(input,52,FOLLOW_11); 

            			newLeafNode(otherlv_11, grammarAccess.getQuizResultAccess().getRightCurlyBracketKeyword_11());
            		
            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getQuizResultAccess().getEndKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuizResult"


    // $ANTLR start "entryRuleUserResponse"
    // InternalQuizDSL.g:1666:1: entryRuleUserResponse returns [EObject current=null] : iv_ruleUserResponse= ruleUserResponse EOF ;
    public final EObject entryRuleUserResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserResponse = null;


        try {
            // InternalQuizDSL.g:1666:53: (iv_ruleUserResponse= ruleUserResponse EOF )
            // InternalQuizDSL.g:1667:2: iv_ruleUserResponse= ruleUserResponse EOF
            {
             newCompositeNode(grammarAccess.getUserResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUserResponse=ruleUserResponse();

            state._fsp--;

             current =iv_ruleUserResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUserResponse"


    // $ANTLR start "ruleUserResponse"
    // InternalQuizDSL.g:1673:1: ruleUserResponse returns [EObject current=null] : (otherlv_0= 'question' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'provided_answer' ( (lv_answer_3_0= RULE_STRING ) ) otherlv_4= 'is_correct' ( (lv_correct_5_0= ruleEBoolean ) ) ) ;
    public final EObject ruleUserResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_answer_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_correct_5_0 = null;



        	enterRule();

        try {
            // InternalQuizDSL.g:1679:2: ( (otherlv_0= 'question' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'provided_answer' ( (lv_answer_3_0= RULE_STRING ) ) otherlv_4= 'is_correct' ( (lv_correct_5_0= ruleEBoolean ) ) ) )
            // InternalQuizDSL.g:1680:2: (otherlv_0= 'question' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'provided_answer' ( (lv_answer_3_0= RULE_STRING ) ) otherlv_4= 'is_correct' ( (lv_correct_5_0= ruleEBoolean ) ) )
            {
            // InternalQuizDSL.g:1680:2: (otherlv_0= 'question' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'provided_answer' ( (lv_answer_3_0= RULE_STRING ) ) otherlv_4= 'is_correct' ( (lv_correct_5_0= ruleEBoolean ) ) )
            // InternalQuizDSL.g:1681:3: otherlv_0= 'question' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'provided_answer' ( (lv_answer_3_0= RULE_STRING ) ) otherlv_4= 'is_correct' ( (lv_correct_5_0= ruleEBoolean ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUserResponseAccess().getQuestionKeyword_0());
            		
            // InternalQuizDSL.g:1685:3: ( (otherlv_1= RULE_ID ) )
            // InternalQuizDSL.g:1686:4: (otherlv_1= RULE_ID )
            {
            // InternalQuizDSL.g:1686:4: (otherlv_1= RULE_ID )
            // InternalQuizDSL.g:1687:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserResponseRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_52); 

            					newLeafNode(otherlv_1, grammarAccess.getUserResponseAccess().getQuestionQuestionCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUserResponseAccess().getProvided_answerKeyword_2());
            		
            // InternalQuizDSL.g:1702:3: ( (lv_answer_3_0= RULE_STRING ) )
            // InternalQuizDSL.g:1703:4: (lv_answer_3_0= RULE_STRING )
            {
            // InternalQuizDSL.g:1703:4: (lv_answer_3_0= RULE_STRING )
            // InternalQuizDSL.g:1704:5: lv_answer_3_0= RULE_STRING
            {
            lv_answer_3_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

            					newLeafNode(lv_answer_3_0, grammarAccess.getUserResponseAccess().getAnswerSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUserResponseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"answer",
            						lv_answer_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,55,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getUserResponseAccess().getIs_correctKeyword_4());
            		
            // InternalQuizDSL.g:1724:3: ( (lv_correct_5_0= ruleEBoolean ) )
            // InternalQuizDSL.g:1725:4: (lv_correct_5_0= ruleEBoolean )
            {
            // InternalQuizDSL.g:1725:4: (lv_correct_5_0= ruleEBoolean )
            // InternalQuizDSL.g:1726:5: lv_correct_5_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getUserResponseAccess().getCorrectEBooleanParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_correct_5_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUserResponseRule());
            					}
            					set(
            						current,
            						"correct",
            						lv_correct_5_0,
            						"org.example.quiz.QuizDSL.EBoolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserResponse"


    // $ANTLR start "ruleUserRole"
    // InternalQuizDSL.g:1747:1: ruleUserRole returns [Enumerator current=null] : ( (enumLiteral_0= 'admin' ) | (enumLiteral_1= 'student' ) ) ;
    public final Enumerator ruleUserRole() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:1753:2: ( ( (enumLiteral_0= 'admin' ) | (enumLiteral_1= 'student' ) ) )
            // InternalQuizDSL.g:1754:2: ( (enumLiteral_0= 'admin' ) | (enumLiteral_1= 'student' ) )
            {
            // InternalQuizDSL.g:1754:2: ( (enumLiteral_0= 'admin' ) | (enumLiteral_1= 'student' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==56) ) {
                alt21=1;
            }
            else if ( (LA21_0==57) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalQuizDSL.g:1755:3: (enumLiteral_0= 'admin' )
                    {
                    // InternalQuizDSL.g:1755:3: (enumLiteral_0= 'admin' )
                    // InternalQuizDSL.g:1756:4: enumLiteral_0= 'admin'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getUserRoleAccess().getADMINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUserRoleAccess().getADMINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:1763:3: (enumLiteral_1= 'student' )
                    {
                    // InternalQuizDSL.g:1763:3: (enumLiteral_1= 'student' )
                    // InternalQuizDSL.g:1764:4: enumLiteral_1= 'student'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getUserRoleAccess().getSTUDENTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getUserRoleAccess().getSTUDENTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserRole"


    // $ANTLR start "ruleAccessType"
    // InternalQuizDSL.g:1774:1: ruleAccessType returns [Enumerator current=null] : ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) ) ;
    public final Enumerator ruleAccessType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalQuizDSL.g:1780:2: ( ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) ) )
            // InternalQuizDSL.g:1781:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) )
            {
            // InternalQuizDSL.g:1781:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==58) ) {
                alt22=1;
            }
            else if ( (LA22_0==59) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalQuizDSL.g:1782:3: (enumLiteral_0= 'public' )
                    {
                    // InternalQuizDSL.g:1782:3: (enumLiteral_0= 'public' )
                    // InternalQuizDSL.g:1783:4: enumLiteral_0= 'public'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getAccessTypeAccess().getPUBLICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAccessTypeAccess().getPUBLICEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalQuizDSL.g:1790:3: (enumLiteral_1= 'private' )
                    {
                    // InternalQuizDSL.g:1790:3: (enumLiteral_1= 'private' )
                    // InternalQuizDSL.g:1791:4: enumLiteral_1= 'private'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getAccessTypeAccess().getPRIVATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAccessTypeAccess().getPRIVATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0002000000440802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0300000000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00002C2000020000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001E80020002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001E00020002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001C00020002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000004000020000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0080000000000000L});

}