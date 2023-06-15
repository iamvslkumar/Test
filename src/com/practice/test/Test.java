import React, { useState } from 'react';

const Popup = () => {
  const [isOpen, setIsOpen] = useState(false);

  const openPopup = () => {
    setIsOpen(true);
  };

  const closePopup = () => {
    setIsOpen(false);
  };

  return (
    <div>
      <button onClick={openPopup}>Open Pop-up</button>
      {isOpen && (
        <div className="popup">
          <h2>This is a Pop-up Box</h2>
          <p>Hello, this is some sample text inside the pop-up box!</p>
          <button onClick={closePopup}>Close</button>
        </div>
      )}
    </div>
  );
};

export default Popup;


file 2

import React, { useState } from 'react';

const Popup = () => {
  const [isOpen, setIsOpen] = useState(false);

  const openPopup = () => {
    setIsOpen(true);
  };

  const closePopup = () => {
    setIsOpen(false);
  };

  const handleButtonClick = () => {
    openPopup(); // Call the function to open the pop-up
  };

  return (
    <div>
      <button onClick={handleButtonClick}>Open Pop-up</button>
      {isOpen && (
        <div className="popup">
          <h2>This is a Pop-up Box</h2>
          <p>Hello, this is some sample text inside the pop-up box!</p>
          <button onClick={closePopup}>Close</button>
        </div>
      )}
    </div>
  );
};

export default Popup;