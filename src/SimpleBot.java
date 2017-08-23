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
	
	final Map<String, String> ANSWER_BY_PATTERNS = new HashMap<String, String>(){{
		put("hello", "Здраствуйте, рад Вас видетью");
		put("who", "Здраствуйте, рад Вас видетью");
		put("name", "Здраствуйте, рад Вас видетью");
		put("howareyou", "Здраствуйте, рад Вас видетью");
		put("whatdoyoudoing", "Я пробую общатся с людьми.");
		put("whatdoyoulike", "Мне нравится думать что я непросто программа");
		put("iamfeelling", "Как давно это началось? ");
		put("yes", "Согласие есть продукт при полном непротивлении сторон");
		put("bye", "До сидания. Надеюсь ещё увидемся.");
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
		
	/*	if (ai) {
			String message =
					String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
			for (Map.Entry<String, String> o : PATTERNS_FOR_ANALYSIS.entrySet()) {
				pattern = Pattern.compile(o.getKey());
				if (pattern.matcher(message).find()) {
					if (o.getValue().equals("whattime")) return date.toString();
					else return ANSWERS_BY_PATTERNS.get(o.getValue());
				}
			}
		}*/
		return say;
	}
}
