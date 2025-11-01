//package com.example.demo.controller;
//
//import com.example.demo.models.User;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.service.UserService;
//import com.example.demo.utils.JwtUtil;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//
//
//   @RestController
//   @RequestMapping("/auth")
//   @RequiredArgsConstructor
//
//   public class AuthController {
//       @Autowired
//       private final UserRepository userRepo;
//       @Autowired
//       private final UserService userService;
//       @Autowired
//       private final JwtUtil jwtUtil;
//       @Autowired
//       private final PasswordEncoder passwordEncoder;
//
//       @PostMapping("/register")
//       public ResponseEntity<String> register(@RequestBody Map<String, String> body) {
//           String email = body.get("email");
//           String password = passwordEncoder.encode(body.get("password"));
//           if (userRepo.findByEmail(email).isPresent()) {
//               return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
//           }
//           userService.createUser(User.builder().email(email).password(password).build());
//           return ResponseEntity.ok("User registered");
//       }
//
//       @PostMapping("/login")
//       public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//           String email = body.get("email");
//           String password = body.get("password");
//
//           var userOpt = userRepo.findByEmail(email);
//           if (userOpt.isEmpty()) {
//               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");
//           }
//
//           var user = userOpt.get();
//           if (!passwordEncoder.matches(password, user.getPassword())) {
//               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//           }
//
//           String token = jwtUtil.generateToken(email);
//           return ResponseEntity.ok(Map.of("token", token));
//       }
//   }