# Using lightweight Nginx image
FROM nginx:alpine

# Removing default nginx static assets
RUN rm -rf /usr/share/nginx/html/*

# Copying static website files
COPY /web-app /usr/share/nginx/html

# Exposing port 80
EXPOSE 80

# Starting Nginx
CMD ["nginx", "-g", "daemon off;"]
