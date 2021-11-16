package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.auth.User;
import com.example.demo.auth.UserSignupService;

@Controller
public class IndexController {
	@Autowired
	private UserSignupService userSignupService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index() {
		// 初期画面へ遷移
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		// ログイン画面へ
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		// ユーザー登録画面へ
		return "signup";
	}
	
	// 「登録する」ボタンを押下
	@PostMapping("/signup")
	public ModelAndView userSignup(@RequestParam("userName") String userName, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("passwordConfirm") String passwordConfirm) {

		ModelAndView mav = new ModelAndView();
		Boolean validateFlg = true;
		List<String> errMsgList = new ArrayList<String>();

		// TODO: フロント側で入力項目のValidateを行う
		// 入力項目が１つでも空の場合
		if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
			validateFlg = false;
			errMsgList.add("すべての項目を入力してください");
		}

		// パスワードとパスワード(確認用)が入力されている場合
		if (!password.isEmpty() && !passwordConfirm.isEmpty()) {
			// パスワードとパスワード(確認用)が等しくない場合
			if (!password.equals(passwordConfirm)) {
				validateFlg = false;
				errMsgList.add("パスワードとパスワード(確認用)が一致しません");
			}
		}

		// Validationエラーの場合
		if (!validateFlg) {
			mav.setViewName("signup");
			mav.addObject("errMsgList", errMsgList);

			return mav;
		}

		User user = new User();
		user.setUsername(userName);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));

		userSignupService.signupUser(user);

		// ユーザー登録が完了したらログイン画面へ遷移
		mav.setViewName("login");
		mav.addObject("message", "ユーザー登録が完了しました");

		return mav;
	}

	// ログイン認証が失敗した場合は"/loginError"へフォワード。
	@PostMapping("/loginError")
	public ModelAndView loginError() {

		ModelAndView mav = new ModelAndView();
		// ログイン画面へ
		mav.setViewName("login");
		mav.addObject("message", "Eメールかパスワードが間違っています");
		return mav;
	}

	// ログイン認証が成功した場合は"/home"へリダイレクト。
	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView();
		// ホーム画面へ
		mav.setViewName("home");
		mav.addObject("message", "ログインしました");
		return mav;
	}

	// ログアウト処理
	@GetMapping("/logout")
	public ModelAndView logout() {

		ModelAndView mav = new ModelAndView();
		// ログイン画面へ
		mav.setViewName("login");
		mav.addObject("message", "ログアウトしました");
		return mav;
	}

}