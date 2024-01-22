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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * SynchronousMachine business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachine related services in the case of a
 *       SynchronousMachine business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachine interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SynchronousMachine
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachine Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineBusinessDelegate
   */
  public static SynchronousMachineBusinessDelegate getSynchronousMachineInstance() {
    return (new SynchronousMachineBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachine(CreateSynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineId() == null)
        command.setSynchronousMachineId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineCommand of SynchronousMachine is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachine(UpdateSynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachine - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSynchronousMachineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachine using Id = " + command.getSynchronousMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachine via SynchronousMachineFetchOneSummary
   *
   * @param summary SynchronousMachineFetchOneSummary
   * @return SynchronousMachineFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachine getSynchronousMachine(SynchronousMachineFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SynchronousMachineFetchOneSummary arg cannot be null");

    SynchronousMachine entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachine
      // --------------------------------------
      CompletableFuture<SynchronousMachine> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineQuery(
                  new LoadSynchronousMachineFilter(summary.getSynchronousMachineId())),
              ResponseTypes.instanceOf(SynchronousMachine.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachine with id " + summary.getSynchronousMachineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachines
   *
   * @return List<SynchronousMachine>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachine> getAllSynchronousMachine() throws ProcessingException {
    List<SynchronousMachine> list = null;

    try {
      CompletableFuture<List<SynchronousMachine>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachine.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachine";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Earthing on SynchronousMachine
   *
   * @param command AssignEarthingToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignEarthing(AssignEarthingToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Earthing on SynchronousMachine
   *
   * @param command UnAssignEarthingFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignEarthing(UnAssignEarthingFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Earthing on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EarthingStarPointR on SynchronousMachine
   *
   * @param command AssignEarthingStarPointRToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignEarthingStarPointR(AssignEarthingStarPointRToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EarthingStarPointR on SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointRFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignEarthingStarPointR(
      UnAssignEarthingStarPointRFromSynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EarthingStarPointR on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EarthingStarPointX on SynchronousMachine
   *
   * @param command AssignEarthingStarPointXToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignEarthingStarPointX(AssignEarthingStarPointXToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EarthingStarPointX on SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointXFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignEarthingStarPointX(
      UnAssignEarthingStarPointXFromSynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EarthingStarPointX on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ikk on SynchronousMachine
   *
   * @param command AssignIkkToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignIkk(AssignIkkToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ikk on SynchronousMachine
   *
   * @param command UnAssignIkkFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignIkk(UnAssignIkkFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ikk on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MaxQ on SynchronousMachine
   *
   * @param command AssignMaxQToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignMaxQ(AssignMaxQToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MaxQ on SynchronousMachine
   *
   * @param command UnAssignMaxQFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignMaxQ(UnAssignMaxQFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MaxQ on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign MinQ on SynchronousMachine
   *
   * @param command AssignMinQToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignMinQ(AssignMinQToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign MinQ on SynchronousMachine
   *
   * @param command UnAssignMinQFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignMinQ(UnAssignMinQFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MinQ on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mu on SynchronousMachine
   *
   * @param command AssignMuToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignMu(AssignMuToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign Mu on SynchronousMachine
   *
   * @param command UnAssignMuFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignMu(UnAssignMuFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mu on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign QPercent on SynchronousMachine
   *
   * @param command AssignQPercentToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignQPercent(AssignQPercentToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign QPercent on SynchronousMachine
   *
   * @param command UnAssignQPercentFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignQPercent(UnAssignQPercentFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign QPercent on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on SynchronousMachine
   *
   * @param command AssignRToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign R on SynchronousMachine
   *
   * @param command UnAssignRFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromSynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R0 on SynchronousMachine
   *
   * @param command AssignR0ToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignR0(AssignR0ToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign R0 on SynchronousMachine
   *
   * @param command UnAssignR0FromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignR0(UnAssignR0FromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R0 on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R2 on SynchronousMachine
   *
   * @param command AssignR2ToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignR2(AssignR2ToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign R2 on SynchronousMachine
   *
   * @param command UnAssignR2FromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignR2(UnAssignR2FromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R2 on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SatDirectSubtransX on SynchronousMachine
   *
   * @param command AssignSatDirectSubtransXToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignSatDirectSubtransX(AssignSatDirectSubtransXToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign SatDirectSubtransX on SynchronousMachine
   *
   * @param command UnAssignSatDirectSubtransXFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignSatDirectSubtransX(
      UnAssignSatDirectSubtransXFromSynchronousMachineCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SatDirectSubtransX on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SatDirectSyncX on SynchronousMachine
   *
   * @param command AssignSatDirectSyncXToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignSatDirectSyncX(AssignSatDirectSyncXToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign SatDirectSyncX on SynchronousMachine
   *
   * @param command UnAssignSatDirectSyncXFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignSatDirectSyncX(UnAssignSatDirectSyncXFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SatDirectSyncX on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SatDirectTransX on SynchronousMachine
   *
   * @param command AssignSatDirectTransXToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignSatDirectTransX(AssignSatDirectTransXToSynchronousMachineCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign SatDirectTransX on SynchronousMachine
   *
   * @param command UnAssignSatDirectTransXFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignSatDirectTransX(UnAssignSatDirectTransXFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SatDirectTransX on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign VoltageRegulationRange on SynchronousMachine
   *
   * @param command AssignVoltageRegulationRangeToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignVoltageRegulationRange(
      AssignVoltageRegulationRangeToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign VoltageRegulationRange on SynchronousMachine
   *
   * @param command UnAssignVoltageRegulationRangeFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageRegulationRange(
      UnAssignVoltageRegulationRangeFromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageRegulationRange on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X0 on SynchronousMachine
   *
   * @param command AssignX0ToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignX0(AssignX0ToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign X0 on SynchronousMachine
   *
   * @param command UnAssignX0FromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignX0(UnAssignX0FromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X0 on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X2 on SynchronousMachine
   *
   * @param command AssignX2ToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void assignX2(AssignX2ToSynchronousMachineCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

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
   * unAssign X2 on SynchronousMachine
   *
   * @param command UnAssignX2FromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void unAssignX2(UnAssignX2FromSynchronousMachineCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X2 on SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add SynchronousMachine to InitiallyUsedBySynchronousMachines
   *
   * @param command AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void addToInitiallyUsedBySynchronousMachines(
      AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getSynchronousMachineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .SynchronousMachineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    SynchronousMachineBusinessDelegate parentDelegate =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getAddTo().getSynchronousMachineId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a SynchronousMachine as InitiallyUsedBySynchronousMachines to SynchronousMachine";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove SynchronousMachine from InitiallyUsedBySynchronousMachines
   *
   * @param command RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand
   * @exception ProcessingException
   */
  public void removeFromInitiallyUsedBySynchronousMachines(
      RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .SynchronousMachineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();
    UUID childId = command.getRemoveFrom().getSynchronousMachineId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachine
   */
  private SynchronousMachine load(UUID id) throws ProcessingException {
    synchronousMachine =
        SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
            .getSynchronousMachine(new SynchronousMachineFetchOneSummary(id));
    return synchronousMachine;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachine synchronousMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineBusinessDelegate.class.getName());
}
