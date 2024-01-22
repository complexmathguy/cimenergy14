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
 * ACLineSegment business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ACLineSegment related services in the case of a ACLineSegment
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ACLineSegment interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ACLineSegment business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ACLineSegmentBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ACLineSegmentBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ACLineSegment Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ACLineSegmentBusinessDelegate
   */
  public static ACLineSegmentBusinessDelegate getACLineSegmentInstance() {
    return (new ACLineSegmentBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createACLineSegment(CreateACLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getACLineSegmentId() == null) command.setACLineSegmentId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateACLineSegmentCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateACLineSegmentCommand of ACLineSegment is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ACLineSegment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateACLineSegmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateACLineSegment(UpdateACLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateACLineSegmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ACLineSegment - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteACLineSegmentCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteACLineSegmentCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteACLineSegmentCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ACLineSegment using Id = " + command.getACLineSegmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ACLineSegment via ACLineSegmentFetchOneSummary
   *
   * @param summary ACLineSegmentFetchOneSummary
   * @return ACLineSegmentFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ACLineSegment getACLineSegment(ACLineSegmentFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ACLineSegmentFetchOneSummary arg cannot be null");

    ACLineSegment entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ACLineSegment
      // --------------------------------------
      CompletableFuture<ACLineSegment> futureEntity =
          queryGateway.query(
              new FindACLineSegmentQuery(new LoadACLineSegmentFilter(summary.getACLineSegmentId())),
              ResponseTypes.instanceOf(ACLineSegment.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ACLineSegment with id " + summary.getACLineSegmentId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ACLineSegments
   *
   * @return List<ACLineSegment>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ACLineSegment> getAllACLineSegment() throws ProcessingException {
    List<ACLineSegment> list = null;

    try {
      CompletableFuture<List<ACLineSegment>> futureList =
          queryGateway.query(
              new FindAllACLineSegmentQuery(),
              ResponseTypes.multipleInstancesOf(ACLineSegment.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ACLineSegment";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B0ch on ACLineSegment
   *
   * @param command AssignB0chToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignB0ch(AssignB0chToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign B0ch on ACLineSegment
   *
   * @param command UnAssignB0chFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignB0ch(UnAssignB0chFromACLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0ch on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Bch on ACLineSegment
   *
   * @param command AssignBchToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignBch(AssignBchToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Bch on ACLineSegment
   *
   * @param command UnAssignBchFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignBch(UnAssignBchFromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Bch on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G0ch on ACLineSegment
   *
   * @param command AssignG0chToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignG0ch(AssignG0chToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign G0ch on ACLineSegment
   *
   * @param command UnAssignG0chFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignG0ch(UnAssignG0chFromACLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G0ch on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Gch on ACLineSegment
   *
   * @param command AssignGchToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignGch(AssignGchToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Gch on ACLineSegment
   *
   * @param command UnAssignGchFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignGch(UnAssignGchFromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Gch on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on ACLineSegment
   *
   * @param command AssignRToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

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
   * unAssign R on ACLineSegment
   *
   * @param command UnAssignRFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R0 on ACLineSegment
   *
   * @param command AssignR0ToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignR0(AssignR0ToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

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
   * unAssign R0 on ACLineSegment
   *
   * @param command UnAssignR0FromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignR0(UnAssignR0FromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R0 on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortCircuitEndTemperature on ACLineSegment
   *
   * @param command AssignShortCircuitEndTemperatureToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignShortCircuitEndTemperature(
      AssignShortCircuitEndTemperatureToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .TemperatureBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .TemperatureBusinessDelegate.getTemperatureInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getTemperatureId();
    Temperature child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Temperature using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortCircuitEndTemperature on ACLineSegment
   *
   * @param command UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignShortCircuitEndTemperature(
      UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortCircuitEndTemperature on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X on ACLineSegment
   *
   * @param command AssignXToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

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
   * unAssign X on ACLineSegment
   *
   * @param command UnAssignXFromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X0 on ACLineSegment
   *
   * @param command AssignX0ToACLineSegmentCommand
   * @exception ProcessingException
   */
  public void assignX0(AssignX0ToACLineSegmentCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getACLineSegmentId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    ACLineSegmentBusinessDelegate parentDelegate =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

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
   * unAssign X0 on ACLineSegment
   *
   * @param command UnAssignX0FromACLineSegmentCommand
   * @exception ProcessingException
   */
  public void unAssignX0(UnAssignX0FromACLineSegmentCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACLineSegmentValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X0 on ACLineSegment";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ACLineSegment
   */
  private ACLineSegment load(UUID id) throws ProcessingException {
    aCLineSegment =
        ACLineSegmentBusinessDelegate.getACLineSegmentInstance()
            .getACLineSegment(new ACLineSegmentFetchOneSummary(id));
    return aCLineSegment;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ACLineSegment aCLineSegment = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACLineSegmentBusinessDelegate.class.getName());
}
