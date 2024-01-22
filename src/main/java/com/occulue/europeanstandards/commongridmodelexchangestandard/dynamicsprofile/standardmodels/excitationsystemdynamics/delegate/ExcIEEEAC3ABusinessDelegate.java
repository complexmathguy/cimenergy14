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
 * ExcIEEEAC3A business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcIEEEAC3A related services in the case of a ExcIEEEAC3A
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ExcIEEEAC3A interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC3A business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcIEEEAC3ABusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcIEEEAC3ABusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcIEEEAC3A Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcIEEEAC3ABusinessDelegate
   */
  public static ExcIEEEAC3ABusinessDelegate getExcIEEEAC3AInstance() {
    return (new ExcIEEEAC3ABusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcIEEEAC3A(CreateExcIEEEAC3ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcIEEEAC3AId() == null) command.setExcIEEEAC3AId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcIEEEAC3ACommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcIEEEAC3ACommand of ExcIEEEAC3A is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcIEEEAC3A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcIEEEAC3ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcIEEEAC3A(UpdateExcIEEEAC3ACommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcIEEEAC3ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcIEEEAC3A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcIEEEAC3ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcIEEEAC3ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcIEEEAC3ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcIEEEAC3A using Id = " + command.getExcIEEEAC3AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcIEEEAC3A via ExcIEEEAC3AFetchOneSummary
   *
   * @param summary ExcIEEEAC3AFetchOneSummary
   * @return ExcIEEEAC3AFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcIEEEAC3A getExcIEEEAC3A(ExcIEEEAC3AFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcIEEEAC3AFetchOneSummary arg cannot be null");

    ExcIEEEAC3A entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcIEEEAC3A
      // --------------------------------------
      CompletableFuture<ExcIEEEAC3A> futureEntity =
          queryGateway.query(
              new FindExcIEEEAC3AQuery(new LoadExcIEEEAC3AFilter(summary.getExcIEEEAC3AId())),
              ResponseTypes.instanceOf(ExcIEEEAC3A.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcIEEEAC3A with id " + summary.getExcIEEEAC3AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC3As
   *
   * @return List<ExcIEEEAC3A>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcIEEEAC3A> getAllExcIEEEAC3A() throws ProcessingException {
    List<ExcIEEEAC3A> list = null;

    try {
      CompletableFuture<List<ExcIEEEAC3A>> futureList =
          queryGateway.query(
              new FindAllExcIEEEAC3AQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC3A.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Efdn on ExcIEEEAC3A
   *
   * @param command AssignEfdnToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignEfdn(AssignEfdnToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Efdn on ExcIEEEAC3A
   *
   * @param command UnAssignEfdnFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignEfdn(UnAssignEfdnFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efdn on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ka on ExcIEEEAC3A
   *
   * @param command AssignKaToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKa(AssignKaToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Ka on ExcIEEEAC3A
   *
   * @param command UnAssignKaFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKa(UnAssignKaFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ka on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kc on ExcIEEEAC3A
   *
   * @param command AssignKcToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKc(AssignKcToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Kc on ExcIEEEAC3A
   *
   * @param command UnAssignKcFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKc(UnAssignKcFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kc on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kd on ExcIEEEAC3A
   *
   * @param command AssignKdToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKd(AssignKdToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Kd on ExcIEEEAC3A
   *
   * @param command UnAssignKdFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKd(UnAssignKdFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kd on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ke on ExcIEEEAC3A
   *
   * @param command AssignKeToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKe(AssignKeToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Ke on ExcIEEEAC3A
   *
   * @param command UnAssignKeFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKe(UnAssignKeFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ke on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf on ExcIEEEAC3A
   *
   * @param command AssignKfToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKf(AssignKfToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Kf on ExcIEEEAC3A
   *
   * @param command UnAssignKfFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKf(UnAssignKfFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kn on ExcIEEEAC3A
   *
   * @param command AssignKnToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKn(AssignKnToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Kn on ExcIEEEAC3A
   *
   * @param command UnAssignKnFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKn(UnAssignKnFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kn on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kr on ExcIEEEAC3A
   *
   * @param command AssignKrToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignKr(AssignKrToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Kr on ExcIEEEAC3A
   *
   * @param command UnAssignKrFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKr(UnAssignKrFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kr on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve1 on ExcIEEEAC3A
   *
   * @param command AssignSeve1ToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignSeve1(AssignSeve1ToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Seve1 on ExcIEEEAC3A
   *
   * @param command UnAssignSeve1FromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignSeve1(UnAssignSeve1FromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve1 on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve2 on ExcIEEEAC3A
   *
   * @param command AssignSeve2ToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignSeve2(AssignSeve2ToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Seve2 on ExcIEEEAC3A
   *
   * @param command UnAssignSeve2FromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignSeve2(UnAssignSeve2FromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve2 on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on ExcIEEEAC3A
   *
   * @param command AssignTaToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Ta on ExcIEEEAC3A
   *
   * @param command UnAssignTaFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tb on ExcIEEEAC3A
   *
   * @param command AssignTbToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignTb(AssignTbToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Tb on ExcIEEEAC3A
   *
   * @param command UnAssignTbFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTb(UnAssignTbFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tb on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tc on ExcIEEEAC3A
   *
   * @param command AssignTcToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignTc(AssignTcToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Tc on ExcIEEEAC3A
   *
   * @param command UnAssignTcFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTc(UnAssignTcFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tc on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Te on ExcIEEEAC3A
   *
   * @param command AssignTeToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignTe(AssignTeToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Te on ExcIEEEAC3A
   *
   * @param command UnAssignTeFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTe(UnAssignTeFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Te on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on ExcIEEEAC3A
   *
   * @param command AssignTfToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Tf on ExcIEEEAC3A
   *
   * @param command UnAssignTfFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamax on ExcIEEEAC3A
   *
   * @param command AssignVamaxToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVamax(AssignVamaxToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Vamax on ExcIEEEAC3A
   *
   * @param command UnAssignVamaxFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVamax(UnAssignVamaxFromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamax on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamin on ExcIEEEAC3A
   *
   * @param command AssignVaminToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVamin(AssignVaminToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Vamin on ExcIEEEAC3A
   *
   * @param command UnAssignVaminFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVamin(UnAssignVaminFromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamin on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve1 on ExcIEEEAC3A
   *
   * @param command AssignVe1ToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVe1(AssignVe1ToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Ve1 on ExcIEEEAC3A
   *
   * @param command UnAssignVe1FromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVe1(UnAssignVe1FromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve1 on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve2 on ExcIEEEAC3A
   *
   * @param command AssignVe2ToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVe2(AssignVe2ToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Ve2 on ExcIEEEAC3A
   *
   * @param command UnAssignVe2FromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVe2(UnAssignVe2FromExcIEEEAC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve2 on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vemin on ExcIEEEAC3A
   *
   * @param command AssignVeminToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVemin(AssignVeminToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Vemin on ExcIEEEAC3A
   *
   * @param command UnAssignVeminFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVemin(UnAssignVeminFromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vemin on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vfemax on ExcIEEEAC3A
   *
   * @param command AssignVfemaxToExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void assignVfemax(AssignVfemaxToExcIEEEAC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC3ABusinessDelegate parentDelegate =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

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
   * unAssign Vfemax on ExcIEEEAC3A
   *
   * @param command UnAssignVfemaxFromExcIEEEAC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVfemax(UnAssignVfemaxFromExcIEEEAC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vfemax on ExcIEEEAC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcIEEEAC3A
   */
  private ExcIEEEAC3A load(UUID id) throws ProcessingException {
    excIEEEAC3A =
        ExcIEEEAC3ABusinessDelegate.getExcIEEEAC3AInstance()
            .getExcIEEEAC3A(new ExcIEEEAC3AFetchOneSummary(id));
    return excIEEEAC3A;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcIEEEAC3A excIEEEAC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC3ABusinessDelegate.class.getName());
}
