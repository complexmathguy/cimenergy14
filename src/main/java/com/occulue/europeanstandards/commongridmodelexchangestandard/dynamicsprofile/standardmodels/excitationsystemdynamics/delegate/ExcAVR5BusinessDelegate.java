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
 * ExcAVR5 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcAVR5 related services in the case of a ExcAVR5 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform ExcAVR5 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcAVR5 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcAVR5BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcAVR5BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcAVR5 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcAVR5BusinessDelegate
   */
  public static ExcAVR5BusinessDelegate getExcAVR5Instance() {
    return (new ExcAVR5BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcAVR5(CreateExcAVR5Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcAVR5Id() == null) command.setExcAVR5Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcAVR5Command - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcAVR5Command of ExcAVR5 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcAVR5 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcAVR5Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcAVR5(UpdateExcAVR5Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcAVR5Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcAVR5 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcAVR5Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcAVR5Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcAVR5Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcAVR5 using Id = " + command.getExcAVR5Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcAVR5 via ExcAVR5FetchOneSummary
   *
   * @param summary ExcAVR5FetchOneSummary
   * @return ExcAVR5FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcAVR5 getExcAVR5(ExcAVR5FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcAVR5FetchOneSummary arg cannot be null");

    ExcAVR5 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcAVR5
      // --------------------------------------
      CompletableFuture<ExcAVR5> futureEntity =
          queryGateway.query(
              new FindExcAVR5Query(new LoadExcAVR5Filter(summary.getExcAVR5Id())),
              ResponseTypes.instanceOf(ExcAVR5.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcAVR5 with id " + summary.getExcAVR5Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcAVR5s
   *
   * @return List<ExcAVR5>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcAVR5> getAllExcAVR5() throws ProcessingException {
    List<ExcAVR5> list = null;

    try {
      CompletableFuture<List<ExcAVR5>> futureList =
          queryGateway.query(
              new FindAllExcAVR5Query(), ResponseTypes.multipleInstancesOf(ExcAVR5.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcAVR5";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Ka on ExcAVR5
   *
   * @param command AssignKaToExcAVR5Command
   * @exception ProcessingException
   */
  public void assignKa(AssignKaToExcAVR5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR5BusinessDelegate parentDelegate = ExcAVR5BusinessDelegate.getExcAVR5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

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
   * unAssign Ka on ExcAVR5
   *
   * @param command UnAssignKaFromExcAVR5Command
   * @exception ProcessingException
   */
  public void unAssignKa(UnAssignKaFromExcAVR5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ka on ExcAVR5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rex on ExcAVR5
   *
   * @param command AssignRexToExcAVR5Command
   * @exception ProcessingException
   */
  public void assignRex(AssignRexToExcAVR5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR5BusinessDelegate parentDelegate = ExcAVR5BusinessDelegate.getExcAVR5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

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
   * unAssign Rex on ExcAVR5
   *
   * @param command UnAssignRexFromExcAVR5Command
   * @exception ProcessingException
   */
  public void unAssignRex(UnAssignRexFromExcAVR5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rex on ExcAVR5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ta on ExcAVR5
   *
   * @param command AssignTaToExcAVR5Command
   * @exception ProcessingException
   */
  public void assignTa(AssignTaToExcAVR5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR5BusinessDelegate parentDelegate = ExcAVR5BusinessDelegate.getExcAVR5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

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
   * unAssign Ta on ExcAVR5
   *
   * @param command UnAssignTaFromExcAVR5Command
   * @exception ProcessingException
   */
  public void unAssignTa(UnAssignTaFromExcAVR5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ta on ExcAVR5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcAVR5
   */
  private ExcAVR5 load(UUID id) throws ProcessingException {
    excAVR5 =
        ExcAVR5BusinessDelegate.getExcAVR5Instance().getExcAVR5(new ExcAVR5FetchOneSummary(id));
    return excAVR5;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcAVR5 excAVR5 = null;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR5BusinessDelegate.class.getName());
}
