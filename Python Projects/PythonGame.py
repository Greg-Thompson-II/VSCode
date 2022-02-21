'''
Created on Jan 22, 2022

@author: gregt
'''
import pygame

WIDTH, HEIGHT = 900, 500
WIN = pygame.display.set_mode((WIDTH, HEIGHT))
#pygame.display.set_caption("First Game")

def PythonGame():
    run = True
    while run:
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
    #input("Press the enter key to quit")            
    pygame.quit()
    input("Press the enter key to quit") 
 
    
if __name__ == "__PythonGame__":
    PythonGame()
    