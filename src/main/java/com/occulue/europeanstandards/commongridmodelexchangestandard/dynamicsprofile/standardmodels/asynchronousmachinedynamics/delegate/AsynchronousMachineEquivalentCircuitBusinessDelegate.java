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
 * AsynchronousMachineEquivalentCircuit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AsynchronousMachineEquivalentCircuit related services in the
 *       case of a AsynchronousMachineEquivalentCircuit business related service failing.
 *   <li>Exposes a simpler, uniform AsynchronousMachineEquivalentCircuit interface to the business
 *       tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       AsynchronousMachineEquivalentCircuit business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AsynchronousMachineEquivalentCircuitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AsynchronousMachineEquivalentCircuitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AsynchronousMachineEquivalentCircuit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AsynchronousMachineEquivalentCircuitBusinessDelegate
   */
  public static AsynchronousMachineEquivalentCircuitBusinessDelegate
      getAsynchronousMachineEquivalentCircuitInstance() {
    return (new AsynchronousMachineEquivalentCircuitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAsynchronousMachineEquivalentCircuit(
      CreateAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAsynchronousMachineEquivalentCircuitId() == null)
        command.setAsynchronousMachineEquivalentCircuitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAsynchronousMachineEquivalentCircuitCommand - by convention the future
      // return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAsynchronousMachineEquivalentCircuitCommand of AsynchronousMachineEquivalentCircuit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AsynchronousMachineEquivalentCircuit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAsynchronousMachineEquivalentCircuitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAsynchronousMachineEquivalentCircuit(
      UpdateAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAsynchronousMachineEquivalentCircuitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AsynchronousMachineEquivalentCircuit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAsynchronousMachineEquivalentCircuitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAsynchronousMachineEquivalentCircuitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AsynchronousMachineEquivalentCircuit using Id = "
              + command.getAsynchronousMachineEquivalentCircuitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AsynchronousMachineEquivalentCircuit via
   * AsynchronousMachineEquivalentCircuitFetchOneSummary
   *
   * @param summary AsynchronousMachineEquivalentCircuitFetchOneSummary
   * @return AsynchronousMachineEquivalentCircuitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AsynchronousMachineEquivalentCircuit getAsynchronousMachineEquivalentCircuit(
      AsynchronousMachineEquivalentCircuitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "AsynchronousMachineEquivalentCircuitFetchOneSummary arg cannot be null");

    AsynchronousMachineEquivalentCircuit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AsynchronousMachineEquivalentCircuit
      // --------------------------------------
      CompletableFuture<AsynchronousMachineEquivalentCircuit> futureEntity =
          queryGateway.query(
              new FindAsynchronousMachineEquivalentCircuitQuery(
                  new LoadAsynchronousMachineEquivalentCircuitFilter(
                      summary.getAsynchronousMachineEquivalentCircuitId())),
              ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AsynchronousMachineEquivalentCircuit with id "
              + summary.getAsynchronousMachineEquivalentCircuitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineEquivalentCircuits
   *
   * @return List<AsynchronousMachineEquivalentCircuit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AsynchronousMachineEquivalentCircuit> getAllAsynchronousMachineEquivalentCircuit()
      throws ProcessingException {
    List<AsynchronousMachineEquivalentCircuit> list = null;

    try {
      CompletableFuture<List<AsynchronousMachineEquivalentCircuit>> futureList =
          queryGateway.query(
              new FindAllAsynchronousMachineEquivalentCircuitQuery(),
              ResponseTypes.multipleInstancesOf(AsynchronousMachineEquivalentCircuit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Rr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr1ToAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignRr1(AssignRr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Rr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignRr1(UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rr1 on AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr2ToAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignRr2(AssignRr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Rr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignRr2(UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rr2 on AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xlr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXlr1(AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xlr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXlr1(UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xlr1 on AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xlr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXlr2(AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xlr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXlr2(UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xlr2 on AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xm on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXmToAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXm(AssignXmToAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAsynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    AsynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xm on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXm(UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AsynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xm on AsynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return AsynchronousMachineEquivalentCircuit
   */
  private AsynchronousMachineEquivalentCircuit load(UUID id) throws ProcessingException {
    asynchronousMachineEquivalentCircuit =
        AsynchronousMachineEquivalentCircuitBusinessDelegate
            .getAsynchronousMachineEquivalentCircuitInstance()
            .getAsynchronousMachineEquivalentCircuit(
                new AsynchronousMachineEquivalentCircuitFetchOneSummary(id));
    return asynchronousMachineEquivalentCircuit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEquivalentCircuitBusinessDelegate.class.getName());
}
