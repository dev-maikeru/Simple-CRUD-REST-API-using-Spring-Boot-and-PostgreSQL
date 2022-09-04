package com.example.takenotes.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Optional<Note> getNote(Long id) {
        return noteRepository.findById(id);
    }
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public Note updateNote(Long id, Note note) {
        Note noteInfo = noteRepository.findById(id).get();

        if (Objects.nonNull(note.getTitle())) {
            noteInfo.setTitle(note.getTitle());
        }
        if (Objects.nonNull(note.getNote())) {
            noteInfo.setNote(note.getNote());
        }

        return noteRepository.save(noteInfo);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
