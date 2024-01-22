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
 * SynchronousMachineTimeConstantReactance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachineTimeConstantReactance related services in the
 *       case of a SynchronousMachineTimeConstantReactance business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachineTimeConstantReactance interface to the
 *       business tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       SynchronousMachineTimeConstantReactance business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineTimeConstantReactanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineTimeConstantReactanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachineTimeConstantReactance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineTimeConstantReactanceBusinessDelegate
   */
  public static SynchronousMachineTimeConstantReactanceBusinessDelegate
      getSynchronousMachineTimeConstantReactanceInstance() {
    return (new SynchronousMachineTimeConstantReactanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachineTimeConstantReactance(
      CreateSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineTimeConstantReactanceId() == null)
        command.setSynchronousMachineTimeConstantReactanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineTimeConstantReactanceCommand - by convention the future
      // return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineTimeConstantReactanceCommand of SynchronousMachineTimeConstantReactance is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachineTimeConstantReactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineTimeConstantReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachineTimeConstantReactance(
      UpdateSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineTimeConstantReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachineTimeConstantReactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineTimeConstantReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(
      DeleteSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineTimeConstantReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachineTimeConstantReactance using Id = "
              + command.getSynchronousMachineTimeConstantReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachineTimeConstantReactance via
   * SynchronousMachineTimeConstantReactanceFetchOneSummary
   *
   * @param summary SynchronousMachineTimeConstantReactanceFetchOneSummary
   * @return SynchronousMachineTimeConstantReactanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachineTimeConstantReactance getSynchronousMachineTimeConstantReactance(
      SynchronousMachineTimeConstantReactanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SynchronousMachineTimeConstantReactanceFetchOneSummary arg cannot be null");

    SynchronousMachineTimeConstantReactance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachineTimeConstantReactance
      // --------------------------------------
      CompletableFuture<SynchronousMachineTimeConstantReactance> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineTimeConstantReactanceQuery(
                  new LoadSynchronousMachineTimeConstantReactanceFilter(
                      summary.getSynchronousMachineTimeConstantReactanceId())),
              ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachineTimeConstantReactance with id "
              + summary.getSynchronousMachineTimeConstantReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
   *
   * @return List<SynchronousMachineTimeConstantReactance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachineTimeConstantReactance>
      getAllSynchronousMachineTimeConstantReactance() throws ProcessingException {
    List<SynchronousMachineTimeConstantReactance> list = null;

    try {
      CompletableFuture<List<SynchronousMachineTimeConstantReactance>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineTimeConstantReactanceQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachineTimeConstantReactance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Ks on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignKsToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignKs(AssignKsToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ks on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignKs(UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ks on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tc on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTcToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTc(AssignTcToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tc on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTc(UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tc on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpdo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpdoToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTpdo(AssignTpdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tpdo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTpdo(UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpdo on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tppdo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppdoToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTppdo(AssignTppdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tppdo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTppdo(UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tppdo on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tppqo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppqoToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTppqo(AssignTppqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tppqo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTppqo(UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tppqo on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpqo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpqoToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignTpqo(AssignTpqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign Tpqo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignTpqo(UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpqo on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XDirectSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXDirectSubtrans(
      AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XDirectSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXDirectSubtrans(
      UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign XDirectSubtrans on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XDirectSync on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXDirectSync(
      AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XDirectSync on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXDirectSync(
      UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign XDirectSync on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XDirectTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXDirectTrans(
      AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XDirectTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXDirectTrans(
      UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign XDirectTrans on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XQuadSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXQuadSubtrans(
      AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XQuadSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXQuadSubtrans(
      UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign XQuadSubtrans on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XQuadSync on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXQuadSync(
      AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XQuadSync on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXQuadSync(
      UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XQuadSync on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XQuadTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void assignXQuadTrans(
      AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineTimeConstantReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineTimeConstantReactanceBusinessDelegate parentDelegate =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

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
   * unAssign XQuadTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignXQuadTrans(
      UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineTimeConstantReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XQuadTrans on SynchronousMachineTimeConstantReactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachineTimeConstantReactance
   */
  private SynchronousMachineTimeConstantReactance load(UUID id) throws ProcessingException {
    synchronousMachineTimeConstantReactance =
        SynchronousMachineTimeConstantReactanceBusinessDelegate
            .getSynchronousMachineTimeConstantReactanceInstance()
            .getSynchronousMachineTimeConstantReactance(
                new SynchronousMachineTimeConstantReactanceFetchOneSummary(id));
    return synchronousMachineTimeConstantReactance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineTimeConstantReactanceBusinessDelegate.class.getName());
}
