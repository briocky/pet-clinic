import React from 'react';

interface StarRatingProps {
    rating: number;
}

const StarRating: React.FC<StarRatingProps> = ({ rating }) => {
    const stars = [];
    for (let i = 0; i < 5; i++) {
        if (i < rating) {
            stars.push(
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="30" height="30">
                    <path fill="gold"
                          d="M12 2l2.371 7.267H22l-6.058 4.398 2.371 7.267L12 16.534 5.687 21.932l2.371-7.267L2 9.267h7.629z"/>
                </svg>
            );
        } else {
            stars.push(
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="30" height="30">
                    <path fill="gold"
                          d="M12 2l2.371 7.267H22l-6.058 4.398 2.371 7.267L12 16.534 5.687 21.932l2.371-7.267L2 9.267h7.629z"/>
                </svg>
            );
        }
    }

    return (
        <div className="flex items-center">
            {stars}
        </div>
    );
};

export default StarRating;
