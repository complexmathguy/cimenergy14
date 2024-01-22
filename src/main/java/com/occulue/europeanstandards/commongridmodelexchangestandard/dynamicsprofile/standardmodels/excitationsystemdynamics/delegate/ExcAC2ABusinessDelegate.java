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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator.*;
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
 * ExcAC2A business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcAC2A related services in the case of a ExcAC2A business
 *       related service failing.
 *   <li>Exposes a simpler, uniform ExcAC2A interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcAC2A business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcAC2ABusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcAC2ABusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcAC2A Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcAC2ABusinessDelegate
   */
  public static ExcAC2ABusinessDelegate getExcAC2AInstance() {
    return (new ExcAC2ABusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcAC2A(CreateExcAC2ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcAC2AId() == null) command.setExcAC2AId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcAC2ACommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcAC2ACommand of ExcAC2A is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcAC2A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcAC2ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcAC2A(UpdateExcAC2ACommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcAC2ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcAC2A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcAC2ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcAC2ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcAC2ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcAC2A using Id = " + command.getExcAC2AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcAC2A via ExcAC2AFetchOneSummary
   *
   * @param summary ExcAC2AFetchOneSummary
   * @return ExcAC2AFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcAC2A getExcAC2A(ExcAC2AFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcAC2AFetchOneSummary arg cannot be null");

    ExcAC2A entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcAC2A
      // --------------------------------------
      CompletableFuture<ExcAC2A> futureEntity =
          queryGateway.query(
              new FindExcAC2AQuery(new LoadExcAC2AFilter(summary.getExcAC2AId())),
              ResponseTypes.instanceOf(ExcAC2A.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcAC2A with id " + summary.getExcAC2AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcAC2As
   *
   * @return List<ExcAC2A>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcAC2A> getAllExcAC2A() throws ProcessingException {
    List<ExcAC2A> list = null;

    try {
      CompletableFuture<List<ExcAC2A>> futureList =
          queryGateway.query(
              new FindAllExcAC2AQuery(), ResponseTypes.multipleInstancesOf(ExcAC2A.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcAC2A";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Hvgate on ExcAC2A
   *
   * @param command AssignHvgateToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignHvgate(AssignHvgateToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Hvgate on ExcAC2A
   *
   * @param command UnAssignHvgateFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignHvgate(UnAssignHvgateFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Hvgate on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ka on ExcAC2A
   *
   * @param command AssignKaToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKa(AssignKaToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ka on ExcAC2A
   *
   * @param command UnAssignKaFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKa(UnAssignKaFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ka on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kb on ExcAC2A
   *
   * @param command AssignKbToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKb(AssignKbToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kb on ExcAC2A
   *
   * @param command UnAssignKbFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKb(UnAssignKbFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kb on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kb1 on ExcAC2A
   *
   * @param command AssignKb1ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKb1(AssignKb1ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kb1 on ExcAC2A
   *
   * @param command UnAssignKb1FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKb1(UnAssignKb1FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kb1 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kc on ExcAC2A
   *
   * @param command AssignKcToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKc(AssignKcToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kc on ExcAC2A
   *
   * @param command UnAssignKcFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKc(UnAssignKcFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kc on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kd on ExcAC2A
   *
   * @param command AssignKdToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKd(AssignKdToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kd on ExcAC2A
   *
   * @param command UnAssignKdFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKd(UnAssignKdFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kd on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ke on ExcAC2A
   *
   * @param command AssignKeToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKe(AssignKeToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ke on ExcAC2A
   *
   * @param command UnAssignKeFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKe(UnAssignKeFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ke on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf on ExcAC2A
   *
   * @param command AssignKfToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKf(AssignKfToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kf on ExcAC2A
   *
   * @param command UnAssignKfFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKf(UnAssignKfFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kh on ExcAC2A
   *
   * @param command AssignKhToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKh(AssignKhToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kh on ExcAC2A
   *
   * @param command UnAssignKhFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKh(UnAssignKhFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kh on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kl on ExcAC2A
   *
   * @param command AssignKlToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKl(AssignKlToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kl on ExcAC2A
   *
   * @param command UnAssignKlFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKl(UnAssignKlFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kl on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kl1 on ExcAC2A
   *
   * @param command AssignKl1ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKl1(AssignKl1ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Kl1 on ExcAC2A
   *
   * @param command UnAssignKl1FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKl1(UnAssignKl1FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kl1 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ks on ExcAC2A
   *
   * @param command AssignKsToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignKs(AssignKsToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ks on ExcAC2A
   *
   * @param command UnAssignKsFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignKs(UnAssignKsFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ks on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lvgate on ExcAC2A
   *
   * @param command AssignLvgateToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignLvgate(AssignLvgateToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Lvgate on ExcAC2A
   *
   * @param command UnAssignLvgateFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignLvgate(UnAssignLvgateFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lvgate on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve1 on ExcAC2A
   *
   * @param command AssignSeve1ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignSeve1(AssignSeve1ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Seve1 on ExcAC2A
   *
   * @param command UnAssignSeve1FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignSeve1(UnAssignSeve1FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve1 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve2 on ExcAC2A
   *
   * @param command AssignSeve2ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignSeve2(AssignSeve2ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Seve2 on ExcAC2A
   *
   * @param command UnAssignSeve2FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignSeve2(UnAssignSeve2FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve2 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on ExcAC2A
   *
   * @param command AssignTaToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ta on ExcAC2A
   *
   * @param command UnAssignTaFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tb on ExcAC2A
   *
   * @param command AssignTbToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignTb(AssignTbToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Tb on ExcAC2A
   *
   * @param command UnAssignTbFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTb(UnAssignTbFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tb on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tc on ExcAC2A
   *
   * @param command AssignTcToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignTc(AssignTcToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Tc on ExcAC2A
   *
   * @param command UnAssignTcFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTc(UnAssignTcFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tc on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Te on ExcAC2A
   *
   * @param command AssignTeToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignTe(AssignTeToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Te on ExcAC2A
   *
   * @param command UnAssignTeFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTe(UnAssignTeFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Te on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on ExcAC2A
   *
   * @param command AssignTfToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Tf on ExcAC2A
   *
   * @param command UnAssignTfFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamax on ExcAC2A
   *
   * @param command AssignVamaxToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVamax(AssignVamaxToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vamax on ExcAC2A
   *
   * @param command UnAssignVamaxFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVamax(UnAssignVamaxFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamax on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamin on ExcAC2A
   *
   * @param command AssignVaminToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVamin(AssignVaminToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vamin on ExcAC2A
   *
   * @param command UnAssignVaminFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVamin(UnAssignVaminFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamin on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve1 on ExcAC2A
   *
   * @param command AssignVe1ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVe1(AssignVe1ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ve1 on ExcAC2A
   *
   * @param command UnAssignVe1FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVe1(UnAssignVe1FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve1 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve2 on ExcAC2A
   *
   * @param command AssignVe2ToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVe2(AssignVe2ToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Ve2 on ExcAC2A
   *
   * @param command UnAssignVe2FromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVe2(UnAssignVe2FromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve2 on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vfemax on ExcAC2A
   *
   * @param command AssignVfemaxToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVfemax(AssignVfemaxToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vfemax on ExcAC2A
   *
   * @param command UnAssignVfemaxFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVfemax(UnAssignVfemaxFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vfemax on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vlr on ExcAC2A
   *
   * @param command AssignVlrToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVlr(AssignVlrToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vlr on ExcAC2A
   *
   * @param command UnAssignVlrFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVlr(UnAssignVlrFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vlr on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmax on ExcAC2A
   *
   * @param command AssignVrmaxToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVrmax(AssignVrmaxToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vrmax on ExcAC2A
   *
   * @param command UnAssignVrmaxFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVrmax(UnAssignVrmaxFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmax on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmin on ExcAC2A
   *
   * @param command AssignVrminToExcAC2ACommand
   * @exception ProcessingException
   */
  public void assignVrmin(AssignVrminToExcAC2ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAC2AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAC2ABusinessDelegate parentDelegate = ExcAC2ABusinessDelegate.getExcAC2AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

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
   * unAssign Vrmin on ExcAC2A
   *
   * @param command UnAssignVrminFromExcAC2ACommand
   * @exception ProcessingException
   */
  public void unAssignVrmin(UnAssignVrminFromExcAC2ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAC2AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmin on ExcAC2A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcAC2A
   */
  private ExcAC2A load(UUID id) throws ProcessingException {
    excAC2A =
        ExcAC2ABusinessDelegate.getExcAC2AInstance().getExcAC2A(new ExcAC2AFetchOneSummary(id));
    return excAC2A;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcAC2A excAC2A = null;
  private static final Logger LOGGER = Logger.getLogger(ExcAC2ABusinessDelegate.class.getName());
}
