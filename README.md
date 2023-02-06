# Kolko_i_Krzyrzyk

Projetk jest wykonania na zajęciach z podstaw programownia. Opis działania: Losuje czy zaczyna X czy O

Można wstawiać w puste pola przez podanie indexu (1-9)

Jest walidacja czy ktoś podaje dobry index, czy w ogóle int a nie dowolny ciąg znaków

Po każdym ruchu odświeża się widok w konsoli

I prosi następnego gracza o podanie indexu

Gra trwa za każdym razem 9 ruchów, bo nie ma mechanizmu sprawdzania czy ktoś wygrał, przygotowałem do tego funkcję która przerwie pętlę gry gdy zwróci true, na razie dałem że zawsze zwraca false - dlatego gra zawsze ma 9 ruchów. W tej funkcji znajduje się również próba mechaniczna. Jeśli zostanie podany index >9 to nie będzie działało poprawnie.
