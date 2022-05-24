package pageUI.tinyServer;

public class HomePUI {
	public static final String SETTING_MENU = "//*[@data-name='settings']//div[@class='site-bar__MenuItems__clickPoint--gmeqo']";
	public static final String ADD_PEOPLE_MENU = "//span[text()='Add People']";
	public static final String FIRSTNAME_TEXTBOX_DYNAMIC = "(//*[@field='firstName'])[%s]";
	public static final String LASTNAME_TEXTBOX_DYNAMIC = "(//*[@field='lastName'])[%s]";
	public static final String EMAIL_TEXTBOX_DYNAMIC = "(//*[@field='email'])[%s]";
	public static final String START_DATE_DYNAMIC = "(//*[@field='startDate'])[%s]";
	public static final String DATE_NEXT_LINK = "//*[text()='chevron_right']";
	public static final String DATE_PREVIOUS_LINK = "//*[text()='chevron_left']";
	public static final String DATE_MONTH_YEAR = "//*[@class='Calendar__title___1bWgS']";
	public static final String DAY_PICKER = "//div[@class='DatesPicker__grid___GHx86 DatesPicker__container___9GkKN']/div";
	public static final String MANAGER_SELECT_DYNAMIC = "(//div[@class='Selecteds__contentWrapper___29qk8'])[%s]";
	public static final String MANAGER_DROPDOWN_DYNAMIC = "//*[@class='Dropdown__dropdown___1qf8H']//*[text()='%s']";
	public static final String LOADING_ICON = "//*[@class='Spinner__backdrop___kWhH1']";
	public static final String ADD_PEOPLE_BUTTON = "//*[ @class='Button__text___13OYb' and text()='Add People']";
	public static final String CONGRATULATION_TEXT = "//*[ @class='tu mv3 fw6 f3 flex items-center green']";
	public static final String USER_LIST_DYNAMIC = "//*[@class='lh-copy']/*[%s]";
	public static final String USER_AVATAR = "//*[@class='Avatar__avatarImage___3rrsr']";
	public static final String LOGOUT_BUTTON = "//*[@class='top-bar__UserOptions__button--3vz9o']";
}
