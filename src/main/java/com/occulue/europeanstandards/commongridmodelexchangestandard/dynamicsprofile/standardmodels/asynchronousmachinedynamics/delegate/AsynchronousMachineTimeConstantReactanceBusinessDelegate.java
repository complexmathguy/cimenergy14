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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.validator.*;
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
 * AsynchronousMachineTimeConstantReactance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AsynchronousMachineTimeConstantReactance related services in the
 *       case of a AsynchronousMachineTimeConstantReactance business related service failing.
 *   <li>Exposes a simpler, uniform AsynchronousMachineTimeConstantReactance interface to the
 *       business tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       AsynchronousMachineTimeConstantReactance business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AsynchronousMachineTimeConstantReactanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AsynchronousMachineTimeConstantReactanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AsynchronousMachineTimeConstantReactance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AsynchronousMachineTimeConstantReactanceBusinessDelegate
   */
  public static AsynchronousMachineTimeConstantReactanceBusinessDelegate
      getAsynchronousMachineTimeConstantReactanceInstance() {
    return (new AsynchronousMachineTimeConstantReactanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAsynchronousMachineTimeConstantReactance(
      CreateAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAsynchronousMachineTimeConstantReactanceId() == null)
        command.setAsynchronousMachineTimeConstantReactanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAsynchronousMachineTimeConstantReactanceCommand - by convention the future
      // return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAsynchronousMachineTimeConstantReactanceCommand of AsynchronousMachineTimeConstantReactance is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AsynchronousMachineTimeConstantReactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAsynchronousMachineTimeConstantReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAsynchronousMachineTimeConstantReactance(
      UpdateAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAsynchronousMachineTimeConstantReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AsynchronousMachineTimeConstantReactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAsynchronousMachineTimeConstantReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(
      DeleteAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAsynchronousMachineTimeConstantReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AsynchronousMachineTimeConstantReactance using Id = "
              + command.getAsynchronousMachineTimeConstantReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AsynchronousMachineTimeConstantReactance via
   * AsynchronousMachineTimeConstantReactanceFetchOneSummary
   *
   * @param summary AsynchronousMachineTimeConstantReactanceFetchOneSummary
   * @return AsynchronousMachineTimeConstantReactanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AsynchronousMachineTimeConstantReactance getAsynchronousMachineTimeConstantReactance(
      AsynchronousMachineTimeConstantReactanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "AsynchronousMachineTimeConstantReactanceFetchOneSummary arg cannot be null");

    AsynchronousMachineTimeConstantReactance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AsynchronousMachineTimeConstantReactance
      // --------------------------------------
      CompletableFuture<AsynchronousMachineTimeConstantReactance> futureEntity =
          queryGateway.query(
              new FindAsynchronousMachineTimeConstantReactanceQuery(
                  new LoadAsynchronousMachineTimeConstantReactanceFilter(
                      summary.getAsynchronousMachineTimeConstantReactanceId())),
              ResponseTypes.instanceOf(AsynchronousMachineTimeConstantReactance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AsynchronousMachineTimeConstantReactance with id "
              + summary.getAsynchronousMachineTimeConstantReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineTimeConstantReactances
   *
   * @return List<AsynchronousMachineTimeConstantReactance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AsynchronousMachineTimeConstantReactance>
      getAllAsynchronousMachineTimeConstantReactance() throws ProcessingException {
    List<AsynchronousMachineTimeConstantReactance> list = null;

    try {
      CompletableFuture<List<AsynchronousMachineTimeConstantReactance>> futureList =
          queryGateway.query(
              new FindAllAsynchronousMachineTimeConstantReactanceQuery(),
              ResponseTypes.multipleInstancesOf(AsynchronousMachineTimeConstantReactance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Tpo on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpoToAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTpo(AssignTpoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    AsynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tpo on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTpo(UnAssignTpoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpo on AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tppo on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppoToAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTppo(AssignTppoToAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    AsynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tppo on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTppo(UnAssignTppoFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tppo on AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xp on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXpToAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXp(AssignXpToAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Xp on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXp(UnAssignXpFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xp on AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xpp on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXppToAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXpp(AssignXppToAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Xpp on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXpp(UnAssignXppFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xpp on AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xs on AsynchronousMachineTimeConstantReactance
   *
   * @param command AssignXsToAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXs(AssignXsToAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Xs on AsynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXs(UnAssignXsFromAsynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xs on AsynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return AsynchronousMachineTimeConstantReactance
   */
  private AsynchronousMachineTimeConstantReactance load(UUID id) throws ProcessingException {
    asynchronousMachineTimeConstantReactance =
        AsynchronousMachineTimeConstantReactanceBusinessDelegate
            .getAsynchronousMachineTimeConstantReactanceInstance()
            .getAsynchronousMachineTimeConstantReactance(
                new AsynchronousMachineTimeConstantReactanceFetchOneSummary(id));
    return asynchronousMachineTimeConstantReactance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineTimeConstantReactanceBusinessDelegate.class.getName());
}
