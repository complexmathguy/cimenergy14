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
 * ExcIEEEDC3A business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcIEEEDC3A related services in the case of a ExcIEEEDC3A
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ExcIEEEDC3A interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcIEEEDC3A business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcIEEEDC3ABusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcIEEEDC3ABusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcIEEEDC3A Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcIEEEDC3ABusinessDelegate
   */
  public static ExcIEEEDC3ABusinessDelegate getExcIEEEDC3AInstance() {
    return (new ExcIEEEDC3ABusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcIEEEDC3A(CreateExcIEEEDC3ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcIEEEDC3AId() == null) command.setExcIEEEDC3AId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcIEEEDC3ACommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcIEEEDC3ACommand of ExcIEEEDC3A is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcIEEEDC3A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcIEEEDC3ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcIEEEDC3A(UpdateExcIEEEDC3ACommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcIEEEDC3ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcIEEEDC3A - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcIEEEDC3ACommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcIEEEDC3ACommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcIEEEDC3ACommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcIEEEDC3A using Id = " + command.getExcIEEEDC3AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcIEEEDC3A via ExcIEEEDC3AFetchOneSummary
   *
   * @param summary ExcIEEEDC3AFetchOneSummary
   * @return ExcIEEEDC3AFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcIEEEDC3A getExcIEEEDC3A(ExcIEEEDC3AFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcIEEEDC3AFetchOneSummary arg cannot be null");

    ExcIEEEDC3A entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcIEEEDC3A
      // --------------------------------------
      CompletableFuture<ExcIEEEDC3A> futureEntity =
          queryGateway.query(
              new FindExcIEEEDC3AQuery(new LoadExcIEEEDC3AFilter(summary.getExcIEEEDC3AId())),
              ResponseTypes.instanceOf(ExcIEEEDC3A.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcIEEEDC3A with id " + summary.getExcIEEEDC3AId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC3As
   *
   * @return List<ExcIEEEDC3A>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcIEEEDC3A> getAllExcIEEEDC3A() throws ProcessingException {
    List<ExcIEEEDC3A> list = null;

    try {
      CompletableFuture<List<ExcIEEEDC3A>> futureList =
          queryGateway.query(
              new FindAllExcIEEEDC3AQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEDC3A.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Efd1 on ExcIEEEDC3A
   *
   * @param command AssignEfd1ToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignEfd1(AssignEfd1ToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Efd1 on ExcIEEEDC3A
   *
   * @param command UnAssignEfd1FromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignEfd1(UnAssignEfd1FromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd1 on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efd2 on ExcIEEEDC3A
   *
   * @param command AssignEfd2ToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignEfd2(AssignEfd2ToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Efd2 on ExcIEEEDC3A
   *
   * @param command UnAssignEfd2FromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignEfd2(UnAssignEfd2FromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd2 on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Exclim on ExcIEEEDC3A
   *
   * @param command AssignExclimToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignExclim(AssignExclimToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Exclim on ExcIEEEDC3A
   *
   * @param command UnAssignExclimFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignExclim(UnAssignExclimFromExcIEEEDC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Exclim on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ke on ExcIEEEDC3A
   *
   * @param command AssignKeToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignKe(AssignKeToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Ke on ExcIEEEDC3A
   *
   * @param command UnAssignKeFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKe(UnAssignKeFromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ke on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kv on ExcIEEEDC3A
   *
   * @param command AssignKvToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignKv(AssignKvToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Kv on ExcIEEEDC3A
   *
   * @param command UnAssignKvFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignKv(UnAssignKvFromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kv on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seefd1 on ExcIEEEDC3A
   *
   * @param command AssignSeefd1ToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignSeefd1(AssignSeefd1ToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Seefd1 on ExcIEEEDC3A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignSeefd1(UnAssignSeefd1FromExcIEEEDC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seefd1 on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seefd2 on ExcIEEEDC3A
   *
   * @param command AssignSeefd2ToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignSeefd2(AssignSeefd2ToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Seefd2 on ExcIEEEDC3A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignSeefd2(UnAssignSeefd2FromExcIEEEDC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seefd2 on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Te on ExcIEEEDC3A
   *
   * @param command AssignTeToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignTe(AssignTeToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Te on ExcIEEEDC3A
   *
   * @param command UnAssignTeFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTe(UnAssignTeFromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Te on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Trh on ExcIEEEDC3A
   *
   * @param command AssignTrhToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignTrh(AssignTrhToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Trh on ExcIEEEDC3A
   *
   * @param command UnAssignTrhFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignTrh(UnAssignTrhFromExcIEEEDC3ACommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Trh on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmax on ExcIEEEDC3A
   *
   * @param command AssignVrmaxToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignVrmax(AssignVrmaxToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Vrmax on ExcIEEEDC3A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVrmax(UnAssignVrmaxFromExcIEEEDC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmax on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmin on ExcIEEEDC3A
   *
   * @param command AssignVrminToExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void assignVrmin(AssignVrminToExcIEEEDC3ACommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEDC3AId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEDC3ABusinessDelegate parentDelegate =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

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
   * unAssign Vrmin on ExcIEEEDC3A
   *
   * @param command UnAssignVrminFromExcIEEEDC3ACommand
   * @exception ProcessingException
   */
  public void unAssignVrmin(UnAssignVrminFromExcIEEEDC3ACommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEDC3AValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmin on ExcIEEEDC3A";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcIEEEDC3A
   */
  private ExcIEEEDC3A load(UUID id) throws ProcessingException {
    excIEEEDC3A =
        ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance()
            .getExcIEEEDC3A(new ExcIEEEDC3AFetchOneSummary(id));
    return excIEEEDC3A;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcIEEEDC3A excIEEEDC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEDC3ABusinessDelegate.class.getName());
}
