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
 * PhaseTapChangerLinear business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PhaseTapChangerLinear related services in the case of a
 *       PhaseTapChangerLinear business related service failing.
 *   <li>Exposes a simpler, uniform PhaseTapChangerLinear interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerLinear
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PhaseTapChangerLinearBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PhaseTapChangerLinearBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PhaseTapChangerLinear Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PhaseTapChangerLinearBusinessDelegate
   */
  public static PhaseTapChangerLinearBusinessDelegate getPhaseTapChangerLinearInstance() {
    return (new PhaseTapChangerLinearBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPhaseTapChangerLinear(
      CreatePhaseTapChangerLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPhaseTapChangerLinearId() == null)
        command.setPhaseTapChangerLinearId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePhaseTapChangerLinearCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePhaseTapChangerLinearCommand of PhaseTapChangerLinear is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PhaseTapChangerLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePhaseTapChangerLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePhaseTapChangerLinear(
      UpdatePhaseTapChangerLinearCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePhaseTapChangerLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PhaseTapChangerLinear - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePhaseTapChangerLinearCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePhaseTapChangerLinearCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePhaseTapChangerLinearCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PhaseTapChangerLinear using Id = "
              + command.getPhaseTapChangerLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PhaseTapChangerLinear via PhaseTapChangerLinearFetchOneSummary
   *
   * @param summary PhaseTapChangerLinearFetchOneSummary
   * @return PhaseTapChangerLinearFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PhaseTapChangerLinear getPhaseTapChangerLinear(
      PhaseTapChangerLinearFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PhaseTapChangerLinearFetchOneSummary arg cannot be null");

    PhaseTapChangerLinear entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PhaseTapChangerLinear
      // --------------------------------------
      CompletableFuture<PhaseTapChangerLinear> futureEntity =
          queryGateway.query(
              new FindPhaseTapChangerLinearQuery(
                  new LoadPhaseTapChangerLinearFilter(summary.getPhaseTapChangerLinearId())),
              ResponseTypes.instanceOf(PhaseTapChangerLinear.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PhaseTapChangerLinear with id " + summary.getPhaseTapChangerLinearId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerLinears
   *
   * @return List<PhaseTapChangerLinear>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PhaseTapChangerLinear> getAllPhaseTapChangerLinear() throws ProcessingException {
    List<PhaseTapChangerLinear> list = null;

    try {
      CompletableFuture<List<PhaseTapChangerLinear>> futureList =
          queryGateway.query(
              new FindAllPhaseTapChangerLinearQuery(),
              ResponseTypes.multipleInstancesOf(PhaseTapChangerLinear.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PhaseTapChangerLinear";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign StepPhaseShiftIncrement on PhaseTapChangerLinear
   *
   * @param command AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void assignStepPhaseShiftIncrement(
      AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    PhaseTapChangerLinearBusinessDelegate parentDelegate =
        PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign StepPhaseShiftIncrement on PhaseTapChangerLinear
   *
   * @param command UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void unAssignStepPhaseShiftIncrement(
      UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StepPhaseShiftIncrement on PhaseTapChangerLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XMax on PhaseTapChangerLinear
   *
   * @param command AssignXMaxToPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void assignXMax(AssignXMaxToPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PhaseTapChangerLinearBusinessDelegate parentDelegate =
        PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

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
   * unAssign XMax on PhaseTapChangerLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void unAssignXMax(UnAssignXMaxFromPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XMax on PhaseTapChangerLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign XMin on PhaseTapChangerLinear
   *
   * @param command AssignXMinToPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void assignXMin(AssignXMinToPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerLinearId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PhaseTapChangerLinearBusinessDelegate parentDelegate =
        PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

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
   * unAssign XMin on PhaseTapChangerLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerLinearCommand
   * @exception ProcessingException
   */
  public void unAssignXMin(UnAssignXMinFromPhaseTapChangerLinearCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerLinearValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign XMin on PhaseTapChangerLinear";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PhaseTapChangerLinear
   */
  private PhaseTapChangerLinear load(UUID id) throws ProcessingException {
    phaseTapChangerLinear =
        PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
            .getPhaseTapChangerLinear(new PhaseTapChangerLinearFetchOneSummary(id));
    return phaseTapChangerLinear;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PhaseTapChangerLinear phaseTapChangerLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerLinearBusinessDelegate.class.getName());
}
