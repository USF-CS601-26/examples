package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * SimpleClient: Reads input from the keyboard and sends it to the server via
 * the socket. File is modified from the code of Prof. Engle
 *
 */
public class ClientForMultithreadedServer extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Client: Started...");
			// Sends a connection request to the server that is running on
			// a given host, "listening" on the given port
			Socket socket = new Socket("localhost", MultithreadedServer.PORT); // running on the local machine

			// For reading user keyboard input from the console
			// (has nothing to do with sockets!)
			Scanner sc  = new Scanner(System.in);

			// For writing to the socket (so that the server could get client messages)
			try(PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
				String input = null;
				while (!socket.isClosed()) {
					input = sc.nextLine(); // read keyboard input
					writer.println(input); // send the message to the server via the socket

					if (input.equals("EXIT")) {
						System.out.println("Client: Ending client.");
						socket.close();
					}
				}
			}
			catch (IOException e) {
				System.out.println(e);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	static void main(String[] args) {
		ClientForMultithreadedServer client = new ClientForMultithreadedServer();
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {
			System.out.println("The thread got interrupted " + e);
		}
	}
}