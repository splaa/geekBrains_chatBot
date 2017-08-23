import java.util.*;
import java.util.regex.*;

public class SimpleBot {
	final String[] COMMON_PHRASES = {
			"Нет ничего ценнее слов, сказанных к месту и ко времени.",
			"Порой мочание может сказаь больше, нежели уйма слов.",
			"Перед тем как писать/говорить всегда лучше подумать",
			"Вежливая и грамотная речь говорит о величии души.",
			"Приятно когда текст без орфографических ошибок.",
			"Многословие есть признак неупорядоченного ума.",
			"Слова могут ранить, но могут исцелять.",
			"Записывая слова, мы удваем их силу",
			"Кто ясно мыслить, тот ясно излагает.",
			"Боюсь Вы что-то не поговариваете."	};
	final String[] ELUSIVE_ANSWERS = {
			"Вопрос непростой, прошу тайм-аут на раздумья",
			"Не уверен, что распологаю такой информацией.",
			"Может лучше поговорим о чем-то другом?",
			"Простите, но это очень личный вопрос.",
			"Не уверен, что Вам понравится ответ.",
			"Поверте, я сам хотел бы это знать?",
			"Вы действительно хотите это знать?",
			"Уверен, Вы уже догадались сами.",
			"Зачем Вам такая информация?",
			"Давае сохраним интригу?"
	};
	
	final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<String, String>(){{
		put("hello", "Здраствуйте, рад Вас видеть.");
		put("who", "Здраствуйте, рад Вас видеть.");
		put("name", "Здраствуйте, рад Вас видеть.");
		put("howareyou", "Здраствуйте, рад Вас видеть.");
		put("whatdoyoudoing", "Я пробую общатся с людьми.");
		put("whatdoyoulike", "Мне нравится думать что я непросто программа");
		put("iamfeelling", "Как давно это началось? ");
		put("yes", "Согласие есть продукт при полном непротивлении сторон");
		put("bye", "До сидания. Надеюсь ещё увидемся.");
	}};
	
	final Map<String, String> PATTERNS_FOR_ANALYSTIS = new HashMap<String, String>(){{
		//hello
		put("хай", "hello");
		put("привет", "hello");
		put("здорово", "hello");
		put("здравствуй", "hello");
		//who
		put("кто\\s.*ты", "who");
		put("ты\\s.*кто", "who");
		//name
		put("как\\s.*зовут", "name");
		put("как\\s.*имя", "name");
		put("есть\\s.*имя", "name");
		put("какое\\s.*имя", "name");
		//howareyou
		put("как\\s.*дела", "howareyou");
		put("как\\s.*жизнь", "howareyou");
		//whatdoyoudoing
		put("зачем\\s.*тут", "whatdoyoudoing");
		put("зачем\\s.*здесь", "whatdoyoudoing");
		put("что\\s.*делаешь", "whatdoyoudoing");
		put("чем\\s.*занимаешся", "whatdoyoudoing");
		//whatdoyoulike
		put("что\\s.*нравится", "whatdoyoulike");
		put("что\\s.*любишь", "whatdoyoulike");
		//iamfeelling
		put("кажется", "iamfeelling");
		put("чувствую", "iamfeelling");
		put("испытываю", "iamfeelling");
		//yes
		put("да", "yes");
		put("согласен", "yes");
		//whattime
		put("который\\s.*час", "whattime");
		put("сколько\\s.*время", "whattime");
		//bye
		put("прощай", "bye");
		put("увидимся", "bye");
		put("до\\s.*свидания", "bye");
	}};
	
	Pattern pattern;    //for regexp
	Random random;      //for random answer
	Date date;          //for date and time
	
	public SimpleBot() {
		this.random = new Random();
		this.date = new Date();
	}
	
	public SimpleBot(Random random, Date date) {
		this.random = random;
		this.date = date;
	}
	
	public String sayInReturn(String msg, boolean ai) {
		String say = (msg.trim().endsWith("?")) ?
		ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
				COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
		
		if (ai) {
			String message =
					String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
			for (Map.Entry<String, String> o : PATTERNS_FOR_ANALYSTIS.entrySet()) {
				pattern = Pattern.compile(o.getKey());
				if (pattern.matcher(message).find()) {
					if (o.getValue().equals("whattime")) return date.toString();
					else return ANSWERS_BY_PATTERNS.get(o.getValue());
				}
			}
		}
		return say;
	}
}
