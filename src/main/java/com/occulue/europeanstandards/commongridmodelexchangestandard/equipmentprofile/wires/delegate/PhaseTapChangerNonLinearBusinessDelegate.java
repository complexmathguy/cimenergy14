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
 * PhaseTapChangerNonLinear business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PhaseTapChangerNonLinear related services in the case of a
 *       PhaseTapChangerNonLinear business related service failing.
 *   <li>Exposes a simpler, uniform PhaseTapChangerNonLinear interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerNonLinear
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PhaseTapChangerNonLinearBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PhaseTapChangerNonLinearBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PhaseTapChangerNonLinear Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PhaseTapChangerNonLinearBusinessDelegate
   */
  public static PhaseTapChangerNonLinearBusinessDelegate getPhaseTapChangerNonLinearInstance() {
    return (new PhaseTapChangerNonLinearBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPhaseTapChangerNonLinear(
      CreatePhaseTapChangerNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPhaseTapChangerNonLinearId() == null)
        command.setPhaseTapChangerNonLinearId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePhaseTapChangerNonLinearCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePhaseTapChangerNonLinearCommand of PhaseTapChangerNonLinear is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PhaseTapChangerNonLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePhaseTapChangerNonLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePhaseTapChangerNonLinear(
      UpdatePhaseTapChangerNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePhaseTapChangerNonLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PhaseTapChangerNonLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePhaseTapChangerNonLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePhaseTapChangerNonLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePhaseTapChangerNonLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PhaseTapChangerNonLinear using Id = "
              + command.getPhaseTapChangerNonLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PhaseTapChangerNonLinear via PhaseTapChangerNonLinearFetchOneSummary
   *
   * @param summary PhaseTapChangerNonLinearFetchOneSummary
   * @return PhaseTapChangerNonLinearFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PhaseTapChangerNonLinear getPhaseTapChangerNonLinear(
      PhaseTapChangerNonLinearFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PhaseTapChangerNonLinearFetchOneSummary arg cannot be null");

    PhaseTapChangerNonLinear entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PhaseTapChangerNonLinear
      // --------------------------------------
      CompletableFuture<PhaseTapChangerNonLinear> futureEntity =
          queryGateway.query(
              new FindPhaseTapChangerNonLinearQuery(
                  new LoadPhaseTapChangerNonLinearFilter(summary.getPhaseTapChangerNonLinearId())),
              ResponseTypes.instanceOf(PhaseTapChangerNonLinear.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PhaseTapChangerNonLinear with id "
              + summary.getPhaseTapChangerNonLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerNonLinears
   *
   * @return List<PhaseTapChangerNonLinear>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PhaseTapChangerNonLinear> getAllPhaseTapChangerNonLinear()
      throws ProcessingException {
    List<PhaseTapChangerNonLinear> list = null;

    try {
      CompletableFuture<List<PhaseTapChangerNonLinear>> futureList =
          queryGateway.query(
              new FindAllPhaseTapChangerNonLinearQuery(),
              ResponseTypes.multipleInstancesOf(PhaseTapChangerNonLinear.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PhaseTapChangerNonLinear";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign VoltageStepIncrement on PhaseTapChangerNonLinear
   *
   * @param command AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void assignVoltageStepIncrement(
      AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    PhaseTapChangerNonLinearBusinessDelegate parentDelegate =
        PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

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
   * unAssign VoltageStepIncrement on PhaseTapChangerNonLinear
   *
   * @param command UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageStepIncrement(
      UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageStepIncrement on PhaseTapChangerNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XMax on PhaseTapChangerNonLinear
   *
   * @param command AssignXMaxToPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void assignXMax(AssignXMaxToPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PhaseTapChangerNonLinearBusinessDelegate parentDelegate =
        PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

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
   * unAssign XMax on PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignXMax(UnAssignXMaxFromPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XMax on PhaseTapChangerNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XMin on PhaseTapChangerNonLinear
   *
   * @param command AssignXMinToPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void assignXMin(AssignXMinToPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerNonLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PhaseTapChangerNonLinearBusinessDelegate parentDelegate =
        PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

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
   * unAssign XMin on PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerNonLinearCommand
   * @exception ProcessingException
   */
  public void unAssignXMin(UnAssignXMinFromPhaseTapChangerNonLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerNonLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XMin on PhaseTapChangerNonLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PhaseTapChangerNonLinear
   */
  private PhaseTapChangerNonLinear load(UUID id) throws ProcessingException {
    phaseTapChangerNonLinear =
        PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
            .getPhaseTapChangerNonLinear(new PhaseTapChangerNonLinearFetchOneSummary(id));
    return phaseTapChangerNonLinear;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PhaseTapChangerNonLinear phaseTapChangerNonLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerNonLinearBusinessDelegate.class.getName());
}
