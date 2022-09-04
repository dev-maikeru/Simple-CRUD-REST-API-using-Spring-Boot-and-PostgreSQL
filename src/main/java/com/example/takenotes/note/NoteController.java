package com.example.takenotes.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    NoteService noteService;

    //GET http://localhost:8080/api/notes/{id}
    @GetMapping("/notes/{id}")
    public Optional<Note> getNote(@PathVariable("id") Long id) {
        return noteService.getNote(id);
    }

    //GET http://localhost:8080/api/notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    //POST http://localhost:8080/api/notes
    @PostMapping("/notes")
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    //PUT http://localhost:8080/api/notes/{id}
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }
    //DELETE http://localhost:8080/api/notes/{id}
    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
    }
}
