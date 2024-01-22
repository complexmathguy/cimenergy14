/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Location business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Location related services in the case of a Location business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Location interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Location business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LocationBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LocationBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Location Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LocationBusinessDelegate
   */
  public static LocationBusinessDelegate getLocationInstance() {
    return (new LocationBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLocation(CreateLocationCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLocationId() == null) command.setLocationId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LocationValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLocationCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLocationCommand of Location is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Location - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLocationCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLocation(UpdateLocationCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LocationValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLocationCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Location - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLocationCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLocationCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LocationValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLocationCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Location using Id = " + command.getLocationId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Location via LocationFetchOneSummary
   *
   * @param summary LocationFetchOneSummary
   * @return LocationFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Location getLocation(LocationFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("LocationFetchOneSummary arg cannot be null");

    Location entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LocationValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Location
      // --------------------------------------
      CompletableFuture<Location> futureEntity =
          queryGateway.query(
              new FindLocationQuery(new LoadLocationFilter(summary.getLocationId())),
              ResponseTypes.instanceOf(Location.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Location with id " + summary.getLocationId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Locations
   *
   * @return List<Location>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Location> getAllLocation() throws ProcessingException {
    List<Location> list = null;

    try {
      CompletableFuture<List<Location>> futureList =
          queryGateway.query(
              new FindAllLocationQuery(), ResponseTypes.multipleInstancesOf(Location.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Location";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Location on Location
   *
   * @param command AssignLocationToLocationCommand
   * @exception ProcessingException
   */
  public void assignLocation(AssignLocationToLocationCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLocationId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
            .delegate.LocationBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard
                .geographicallocationprofile.common.delegate.LocationBusinessDelegate
                .getLocationInstance();
    LocationBusinessDelegate parentDelegate = LocationBusinessDelegate.getLocationInstance();
    UUID childId = command.getAssignment().getLocationId();
    Location child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LocationValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Location using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Location on Location
   *
   * @param command UnAssignLocationFromLocationCommand
   * @exception ProcessingException
   */
  public void unAssignLocation(UnAssignLocationFromLocationCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LocationValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Location on Location";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Location
   */
  private Location load(UUID id) throws ProcessingException {
    location =
        LocationBusinessDelegate.getLocationInstance().getLocation(new LocationFetchOneSummary(id));
    return location;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Location location = null;
  private static final Logger LOGGER = Logger.getLogger(LocationBusinessDelegate.class.getName());
}
