package pl.sdacademy.library.service;

import pl.sdacademy.library.entity.Author;
import pl.sdacademy.library.repository.AuthorRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuthorService {

    @EJB
    private AuthorRepository authorRepository;

    public List<Author> getAuthors(int page, int size) {
        return authorRepository.findPage(page, size);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findOne(id);
    }

    public void createAuthor(String firstName, String lastName, String biography) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBiography(biography);
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        Author author = authorRepository.findOne(id);
        authorRepository.delete(author);
    }

    public void updateAuthor(Long id, String firstName, String lastName, String biography) {
        Author author = authorRepository.findOne(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBiography(biography);
    }

    public long getCount() {
        return authorRepository.count();
    }
}
