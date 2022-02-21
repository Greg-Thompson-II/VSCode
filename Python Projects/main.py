'''
Created on Jan 22, 2022

#Learning Python
#Created while following pygame youtube video by Tech With Tim 
#Working code

@author: gregt
'''
import pygame
import os
pygame.font.init()
pygame.mixer.init()

#Create Height and Width variables
WIDTH, HEIGHT = 900, 500
WIN = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("First Game")

#Create color variables
WHITE = (255, 255, 255)
BLUE = (13, 71, 161)
#BLUE = (70, 130, 180)
RED = (255, 0, 0)
YELLOW = (255, 255, 0)

#Creating center border
BORDER = pygame.Rect(WIDTH//2 - 5, 0, 10, HEIGHT)

#Creating Varibles for sounds...also adding paths to sounds
BULLET_HIT_SOUND = pygame.mixer.Sound(os.path.join('Assets/Grenade+1.mp3'))
BULLET_FIRE_SOUND = pygame.mixer.Sound(os.path.join('Assets/laser-gun-19sf.mp3'))

#Creating and assigning font variables and configurations
HEALTH_FONT = pygame.font.SysFont('comicsanc', 40)
WINNER_FONT = pygame.font.SysFont('comicsanc', 100)

#Creating variables for Frames per Second to help run on all devices, ship and bullet velocity,... 
# max bullets on screen, and spaceship dimensions
FPS = 60
VEL = 5
BULLETS_VEL = 7
MAX_BULLETS = 3
SPACESHIP_WIDTH, SPACESHIP_HEIGHT = 55, 40

#Creating user events for game
YELLOW_HIT = pygame.USEREVENT + 1
RED_HIT = pygame.USEREVENT + 2

#Loading and formating spaceship visuals
YELLOW_SPACESHIP_IMAGE = pygame.image.load(
    os.path.join('Assets', 'spaceship_yellow.png'))
YELLOW_SPACESHIP = pygame.transform.rotate(
    pygame.transform.scale(YELLOW_SPACESHIP_IMAGE, (SPACESHIP_WIDTH, SPACESHIP_HEIGHT)), 90)


RED_SPACESHIP_IMAGE = pygame.image.load(
    os.path.join('Assets', 'spaceship_red.png'))
RED_SPACESHIP = pygame.transform.rotate(
    pygame.transform.scale(RED_SPACESHIP_IMAGE, (SPACESHIP_WIDTH, SPACESHIP_HEIGHT)), 270)

SPACE = pygame.transform.scale(pygame.image.load(
    os.path.join('Assets', 'space.png')), (WIDTH, HEIGHT))

#Creating visuals for health text, spaceships, and bullets
def draw_window(red, yellow, red_bullets, yellow_bullets, red_health, yellow_health):
    WIN.blit(SPACE, (0,0))
    pygame.draw.rect(WIN, BLUE, BORDER)
    
    red_health_text = HEALTH_FONT.render("Health: " + str(red_health), 1, WHITE)
    yellow_health_text = HEALTH_FONT.render("Health: " + str(yellow_health), 1, WHITE)
    WIN.blit(red_health_text, (WIDTH - red_health_text.get_width() - 10, 10))
    WIN.blit(yellow_health_text, (10, 10))
    
    WIN.blit(YELLOW_SPACESHIP, (yellow.x, yellow.y))
    WIN.blit(RED_SPACESHIP, (red.x, red.y))
    
    for bullet in red_bullets:
        pygame.draw.rect(WIN, RED, bullet)
    
    for bullet in yellow_bullets:
        pygame.draw.rect(WIN, YELLOW, bullet)
    
    pygame.display.update()
    
#Controls for yellow spaceship
def yellow_handle_movement(keys_pressed, yellow):
    if keys_pressed[pygame.K_a] and yellow.x - VEL > 0: # Left
        yellow.x -= VEL
    if keys_pressed[pygame.K_d] and yellow.x + VEL + yellow.width < BORDER.x: # Right
        yellow.x += VEL
    if keys_pressed[pygame.K_s] and yellow.y + VEL + yellow.height < HEIGHT - 15: # Down
        yellow.y += VEL
    if keys_pressed[pygame.K_w] and yellow.y - VEL > 0: # Up
        yellow.y -= VEL
        
#Controls for red spaceship
def red_handle_movement(keys_pressed, red):
    if keys_pressed[pygame.K_LEFT] and red.x - VEL > BORDER.x + BORDER.width: # Left
        red.x -= VEL
    if keys_pressed[pygame.K_RIGHT] and red.x + VEL + red.width < WIDTH: # Right
        red.x += VEL
    if keys_pressed[pygame.K_DOWN] and red.y + VEL + red.height < HEIGHT - 15: # Down
        red.y += VEL
    if keys_pressed[pygame.K_UP] and red.y - VEL > 0: # Up
        red.y -= VEL
        
#Creating events for bullets (i.e. hitting opponent, bullets leaving screen)
def handle_bullets(yellow_bullets, red_bullets, yellow, red):
    for bullet in yellow_bullets:
        bullet.x += BULLETS_VEL
        if red.colliderect(bullet):
            pygame.event.post(pygame.event.Event(RED_HIT))
            yellow_bullets.remove(bullet)
        elif bullet.x > WIDTH:
            yellow_bullets.remove(bullet)
            
    for bullet in red_bullets:
        bullet.x -= BULLETS_VEL
        if yellow.colliderect(bullet):
            pygame.event.post(pygame.event.Event(YELLOW_HIT))
            red_bullets.remove(bullet)
        elif bullet.x < 0:
            red_bullets.remove(bullet)
         
#Winner text display
def draw_winner(text):
    draw_text = WINNER_FONT.render(text, 1, WHITE)
    WIN.blit(draw_text, (WIDTH/2 - draw_text.get_width()/2, HEIGHT/2 - draw_text.get_height()/2))
    pygame.display.update()
    pygame.time.delay(5000)
        

def main():
    #Loading in player ships
    red = pygame.Rect(700, 300, SPACESHIP_WIDTH, SPACESHIP_HEIGHT)
    yellow = pygame.Rect(100, 300, SPACESHIP_WIDTH, SPACESHIP_HEIGHT)
    
    #Loading in bullets
    red_bullets = []
    yellow_bullets = []
    
    #Loading in health
    red_health = 10
    yellow_health = 10
    
    #Creating costant loop until win or game is closed
    clock = pygame.time.Clock()
    run = True
    while run:
        #Run clock at 60 frames per second
        clock.tick(FPS)
        #redraw window
        pygame.display.update()
        #quit if users close window
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                pygame.quit()
            
            #checking for players shooting bullets    
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LSHIFT and len(yellow_bullets) < MAX_BULLETS:
                    bullet = pygame.Rect(
                        yellow.x + yellow.width, yellow.y + yellow.height//2 - 2, 10, 5)
                    yellow_bullets.append(bullet)
                    BULLET_FIRE_SOUND.play()
                
                if event.key == pygame.K_RSHIFT and len(red_bullets) < MAX_BULLETS:
                    bullet = pygame.Rect(
                        red.x, red.y + red.height//2 - 2, 10, 5)
                    red_bullets.append(bullet)
                    BULLET_FIRE_SOUND.play()
            
            #creating sound if cullet hits a spaceship
            if event.type == RED_HIT:
                red_health -= 1 
                BULLET_HIT_SOUND.play()
                
            if event.type == YELLOW_HIT:      
                yellow_health -= 1
                BULLET_HIT_SOUND.play()
        
        #Winner outputs
        winner_text = " "        
        if red_health <= 0:
            winner_text = "Yellow Wins!"
            
        if yellow_health <= 0:
            winner_text = "Red Wins"
            
        if winner_text != " ":
            draw_winner(winner_text)
            break
        
        #Looking for pressed keys
        keys_pressed = pygame.key.get_pressed()
        yellow_handle_movement(keys_pressed, yellow)
        red_handle_movement(keys_pressed, red)
        
        #Checking for what bullets have done since window redraw
        handle_bullets(yellow_bullets, red_bullets, yellow, red)
        
        #created new window with updated values...must be updated for changes to be seen
        draw_window(red, yellow, red_bullets, yellow_bullets, red_health, yellow_health)
        
        #loop 
        
    #restarts game so users can play game again...ends when users close window    
    main()
 
    
#only runs if file is named "main.py"
if __name__ == "__main__":
    main()
    