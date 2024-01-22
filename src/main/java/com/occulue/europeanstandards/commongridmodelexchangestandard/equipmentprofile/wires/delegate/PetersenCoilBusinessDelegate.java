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
 * PetersenCoil business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PetersenCoil related services in the case of a PetersenCoil
 *       business related service failing.
 *   <li>Exposes a simpler, uniform PetersenCoil interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PetersenCoil business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PetersenCoilBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PetersenCoilBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PetersenCoil Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PetersenCoilBusinessDelegate
   */
  public static PetersenCoilBusinessDelegate getPetersenCoilInstance() {
    return (new PetersenCoilBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPetersenCoil(CreatePetersenCoilCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPetersenCoilId() == null) command.setPetersenCoilId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePetersenCoilCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePetersenCoilCommand of PetersenCoil is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PetersenCoil - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePetersenCoilCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePetersenCoil(UpdatePetersenCoilCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePetersenCoilCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PetersenCoil - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePetersenCoilCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePetersenCoilCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePetersenCoilCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PetersenCoil using Id = " + command.getPetersenCoilId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PetersenCoil via PetersenCoilFetchOneSummary
   *
   * @param summary PetersenCoilFetchOneSummary
   * @return PetersenCoilFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PetersenCoil getPetersenCoil(PetersenCoilFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PetersenCoilFetchOneSummary arg cannot be null");

    PetersenCoil entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PetersenCoil
      // --------------------------------------
      CompletableFuture<PetersenCoil> futureEntity =
          queryGateway.query(
              new FindPetersenCoilQuery(new LoadPetersenCoilFilter(summary.getPetersenCoilId())),
              ResponseTypes.instanceOf(PetersenCoil.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate PetersenCoil with id " + summary.getPetersenCoilId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PetersenCoils
   *
   * @return List<PetersenCoil>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PetersenCoil> getAllPetersenCoil() throws ProcessingException {
    List<PetersenCoil> list = null;

    try {
      CompletableFuture<List<PetersenCoil>> futureList =
          queryGateway.query(
              new FindAllPetersenCoilQuery(),
              ResponseTypes.multipleInstancesOf(PetersenCoil.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PetersenCoil";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NominalU on PetersenCoil
   *
   * @param command AssignNominalUToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignNominalU(AssignNominalUToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NominalU on PetersenCoil
   *
   * @param command UnAssignNominalUFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignNominalU(UnAssignNominalUFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NominalU on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign OffsetCurrent on PetersenCoil
   *
   * @param command AssignOffsetCurrentToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignOffsetCurrent(AssignOffsetCurrentToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

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
   * unAssign OffsetCurrent on PetersenCoil
   *
   * @param command UnAssignOffsetCurrentFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignOffsetCurrent(UnAssignOffsetCurrentFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign OffsetCurrent on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PositionCurrent on PetersenCoil
   *
   * @param command AssignPositionCurrentToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignPositionCurrent(AssignPositionCurrentToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

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
   * unAssign PositionCurrent on PetersenCoil
   *
   * @param command UnAssignPositionCurrentFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignPositionCurrent(UnAssignPositionCurrentFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositionCurrent on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XGroundMax on PetersenCoil
   *
   * @param command AssignXGroundMaxToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignXGroundMax(AssignXGroundMaxToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

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
   * unAssign XGroundMax on PetersenCoil
   *
   * @param command UnAssignXGroundMaxFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignXGroundMax(UnAssignXGroundMaxFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XGroundMax on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XGroundMin on PetersenCoil
   *
   * @param command AssignXGroundMinToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignXGroundMin(AssignXGroundMinToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

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
   * unAssign XGroundMin on PetersenCoil
   *
   * @param command UnAssignXGroundMinFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignXGroundMin(UnAssignXGroundMinFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XGroundMin on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XGroundNominal on PetersenCoil
   *
   * @param command AssignXGroundNominalToPetersenCoilCommand
   * @exception ProcessingException
   */
  public void assignXGroundNominal(AssignXGroundNominalToPetersenCoilCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPetersenCoilId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PetersenCoilBusinessDelegate parentDelegate =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

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
   * unAssign XGroundNominal on PetersenCoil
   *
   * @param command UnAssignXGroundNominalFromPetersenCoilCommand
   * @exception ProcessingException
   */
  public void unAssignXGroundNominal(UnAssignXGroundNominalFromPetersenCoilCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PetersenCoilValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XGroundNominal on PetersenCoil";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PetersenCoil
   */
  private PetersenCoil load(UUID id) throws ProcessingException {
    petersenCoil =
        PetersenCoilBusinessDelegate.getPetersenCoilInstance()
            .getPetersenCoil(new PetersenCoilFetchOneSummary(id));
    return petersenCoil;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PetersenCoil petersenCoil = null;
  private static final Logger LOGGER =
      Logger.getLogger(PetersenCoilBusinessDelegate.class.getName());
}
