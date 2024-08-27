package com.filterrecipe.auth.dto;

import com.filterrecipe.recipe.dto.Bookmark;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false, unique = true)
    private String email;

    private String nickname;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bookmark> bookmarks = new HashSet<>();

    @Builder
    public User(String loginId, String email, String nickname, String password) {
        this.loginId = loginId;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public void addBookmark(Bookmark bookmark) {
        this.bookmarks.add(bookmark);
        bookmark.setUser(this);
    }

    public void removeBookmark(Bookmark bookmark) {
        this.bookmarks.remove(bookmark);
        bookmark.setUser(null);
    }
}