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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator.*;
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
 * SynchronousMachineEquivalentCircuit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachineEquivalentCircuit related services in the case
 *       of a SynchronousMachineEquivalentCircuit business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachineEquivalentCircuit interface to the business
 *       tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       SynchronousMachineEquivalentCircuit business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineEquivalentCircuitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineEquivalentCircuitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachineEquivalentCircuit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineEquivalentCircuitBusinessDelegate
   */
  public static SynchronousMachineEquivalentCircuitBusinessDelegate
      getSynchronousMachineEquivalentCircuitInstance() {
    return (new SynchronousMachineEquivalentCircuitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachineEquivalentCircuit(
      CreateSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineEquivalentCircuitId() == null)
        command.setSynchronousMachineEquivalentCircuitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineEquivalentCircuitCommand - by convention the future
      // return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineEquivalentCircuitCommand of SynchronousMachineEquivalentCircuit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachineEquivalentCircuit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineEquivalentCircuitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachineEquivalentCircuit(
      UpdateSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineEquivalentCircuitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachineEquivalentCircuit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineEquivalentCircuitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineEquivalentCircuitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachineEquivalentCircuit using Id = "
              + command.getSynchronousMachineEquivalentCircuitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachineEquivalentCircuit via
   * SynchronousMachineEquivalentCircuitFetchOneSummary
   *
   * @param summary SynchronousMachineEquivalentCircuitFetchOneSummary
   * @return SynchronousMachineEquivalentCircuitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachineEquivalentCircuit getSynchronousMachineEquivalentCircuit(
      SynchronousMachineEquivalentCircuitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SynchronousMachineEquivalentCircuitFetchOneSummary arg cannot be null");

    SynchronousMachineEquivalentCircuit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachineEquivalentCircuit
      // --------------------------------------
      CompletableFuture<SynchronousMachineEquivalentCircuit> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineEquivalentCircuitQuery(
                  new LoadSynchronousMachineEquivalentCircuitFilter(
                      summary.getSynchronousMachineEquivalentCircuitId())),
              ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachineEquivalentCircuit with id "
              + summary.getSynchronousMachineEquivalentCircuitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineEquivalentCircuits
   *
   * @return List<SynchronousMachineEquivalentCircuit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachineEquivalentCircuit> getAllSynchronousMachineEquivalentCircuit()
      throws ProcessingException {
    List<SynchronousMachineEquivalentCircuit> list = null;

    try {
      CompletableFuture<List<SynchronousMachineEquivalentCircuit>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineEquivalentCircuitQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachineEquivalentCircuit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign R1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1dToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignR1d(AssignR1dToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign R1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignR1d(UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R1d on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R1q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1qToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignR1q(AssignR1qToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign R1q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignR1q(UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R1q on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R2q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR2qToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignR2q(AssignR2qToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign R2q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignR2q(UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R2q on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rfd on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignRfdToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignRfd(AssignRfdToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Rfd on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignRfd(UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rfd on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1dToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignX1d(AssignX1dToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign X1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignX1d(UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X1d on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X1q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1qToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignX1q(AssignX1qToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign X1q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignX1q(UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X1q on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X2q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX2qToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignX2q(AssignX2qToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign X2q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignX2q(UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X2q on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xad on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXadToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXad(AssignXadToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xad on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXadFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXad(UnAssignXadFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xad on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xaq on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXaqToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXaq(AssignXaqToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xaq on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXaq(UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xaq on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xf1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXf1dToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXf1d(AssignXf1dToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xf1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXf1d(UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xf1d on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xfd on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXfdToSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void assignXfd(AssignXfdToSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineEquivalentCircuitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineEquivalentCircuitBusinessDelegate parentDelegate =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

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
   * unAssign Xfd on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand
   * @exception ProcessingException
   */
  public void unAssignXfd(UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineEquivalentCircuitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xfd on SynchronousMachineEquivalentCircuit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachineEquivalentCircuit
   */
  private SynchronousMachineEquivalentCircuit load(UUID id) throws ProcessingException {
    synchronousMachineEquivalentCircuit =
        SynchronousMachineEquivalentCircuitBusinessDelegate
            .getSynchronousMachineEquivalentCircuitInstance()
            .getSynchronousMachineEquivalentCircuit(
                new SynchronousMachineEquivalentCircuitFetchOneSummary(id));
    return synchronousMachineEquivalentCircuit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEquivalentCircuitBusinessDelegate.class.getName());
}
