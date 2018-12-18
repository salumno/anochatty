export interface ChatMessage {
  message: string,
  isReceived: boolean
}

export interface WebSocketChatMessage {
  senderId: number,
  message: string
}
