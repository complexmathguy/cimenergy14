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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindContPType4bIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindContPType4bIEC related services in the case of a
 *       WindContPType4bIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindContPType4bIEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindContPType4bIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindContPType4bIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindContPType4bIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindContPType4bIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindContPType4bIECBusinessDelegate
   */
  public static WindContPType4bIECBusinessDelegate getWindContPType4bIECInstance() {
    return (new WindContPType4bIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindContPType4bIEC(CreateWindContPType4bIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindContPType4bIECId() == null)
        command.setWindContPType4bIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindContPType4bIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindContPType4bIECCommand of WindContPType4bIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindContPType4bIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindContPType4bIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindContPType4bIEC(UpdateWindContPType4bIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindContPType4bIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindContPType4bIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindContPType4bIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindContPType4bIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindContPType4bIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindContPType4bIEC using Id = " + command.getWindContPType4bIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindContPType4bIEC via WindContPType4bIECFetchOneSummary
   *
   * @param summary WindContPType4bIECFetchOneSummary
   * @return WindContPType4bIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindContPType4bIEC getWindContPType4bIEC(WindContPType4bIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindContPType4bIECFetchOneSummary arg cannot be null");

    WindContPType4bIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindContPType4bIEC
      // --------------------------------------
      CompletableFuture<WindContPType4bIEC> futureEntity =
          queryGateway.query(
              new FindWindContPType4bIECQuery(
                  new LoadWindContPType4bIECFilter(summary.getWindContPType4bIECId())),
              ResponseTypes.instanceOf(WindContPType4bIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindContPType4bIEC with id " + summary.getWindContPType4bIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindContPType4bIECs
   *
   * @return List<WindContPType4bIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindContPType4bIEC> getAllWindContPType4bIEC() throws ProcessingException {
    List<WindContPType4bIEC> list = null;

    try {
      CompletableFuture<List<WindContPType4bIEC>> futureList =
          queryGateway.query(
              new FindAllWindContPType4bIECQuery(),
              ResponseTypes.multipleInstancesOf(WindContPType4bIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindContPType4bIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Dpmax on WindContPType4bIEC
   *
   * @param command AssignDpmaxToWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void assignDpmax(AssignDpmaxToWindContPType4bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPType4bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContPType4bIECBusinessDelegate parentDelegate =
        WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Dpmax on WindContPType4bIEC
   *
   * @param command UnAssignDpmaxFromWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void unAssignDpmax(UnAssignDpmaxFromWindContPType4bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dpmax on WindContPType4bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpaero on WindContPType4bIEC
   *
   * @param command AssignTpaeroToWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void assignTpaero(AssignTpaeroToWindContPType4bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPType4bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContPType4bIECBusinessDelegate parentDelegate =
        WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tpaero on WindContPType4bIEC
   *
   * @param command UnAssignTpaeroFromWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpaero(UnAssignTpaeroFromWindContPType4bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpaero on WindContPType4bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpord on WindContPType4bIEC
   *
   * @param command AssignTpordToWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void assignTpord(AssignTpordToWindContPType4bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPType4bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContPType4bIECBusinessDelegate parentDelegate =
        WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tpord on WindContPType4bIEC
   *
   * @param command UnAssignTpordFromWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpord(UnAssignTpordFromWindContPType4bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpord on WindContPType4bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tufilt on WindContPType4bIEC
   *
   * @param command AssignTufiltToWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void assignTufilt(AssignTufiltToWindContPType4bIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContPType4bIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContPType4bIECBusinessDelegate parentDelegate =
        WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tufilt on WindContPType4bIEC
   *
   * @param command UnAssignTufiltFromWindContPType4bIECCommand
   * @exception ProcessingException
   */
  public void unAssignTufilt(UnAssignTufiltFromWindContPType4bIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContPType4bIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tufilt on WindContPType4bIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindContPType4bIEC
   */
  private WindContPType4bIEC load(UUID id) throws ProcessingException {
    windContPType4bIEC =
        WindContPType4bIECBusinessDelegate.getWindContPType4bIECInstance()
            .getWindContPType4bIEC(new WindContPType4bIECFetchOneSummary(id));
    return windContPType4bIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindContPType4bIEC windContPType4bIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4bIECBusinessDelegate.class.getName());
}
