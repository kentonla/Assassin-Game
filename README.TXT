# Assassin-Game

This is "Assassin", a game where players are trying to eliminate their assigned targets without being eliminated themselves.

Each player only knows their own target and does not know who is targeting them or who the other players are targeting.

The game is played with a group of people, and the targets are randomly assigned in a circular chain called the "kill ring". For example, if there are five players named Isabella, Ray, Norman, Emma, and Phil, the kill ring might be arranged such that Isabella is targeting Ray, Ray is targeting Norman, Norman is targeting Emma, Emma is targeting Phil, and Phil is targeting Isabella.

The kill ring is represented as a linked list, with the next person in the list being the target of the current player. If a player is killed, they are sent to the graveyard and removed from the kill ring.