package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOG.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public String home(RedirectAttributes r) {
		LOG.info("Welcome home! The client locale is ");
		r.addFlashAttribute("msg", "nonono");
		return "redirect:/home1";
	}

	@RequestMapping(value = "/home1", method = RequestMethod.GET)
	public void home1(String msg) {
		LOG.info("[" + msg);
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody ProductVO home2() {
		LOG.info("Welcome home! The client locale is ");
		ProductVO vo = new ProductVO("abc", 123);

		return vo;
	}
}
