package edu.ntnu.idi.idatt.model;

/**
 * Represents a data pair containing an author and the number of posts
 * associated with that author.
 *
 * @param author    the author this count belongs to
 * @param postCount the number of diary entries written by the author
 */
public record AuthorPostCount(Author author, int postCount) {}
