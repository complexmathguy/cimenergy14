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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.validator.*;
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
 * OverexcLimX1 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of OverexcLimX1 related services in the case of a OverexcLimX1
 *       business related service failing.
 *   <li>Exposes a simpler, uniform OverexcLimX1 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill OverexcLimX1 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class OverexcLimX1BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public OverexcLimX1BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * OverexcLimX1 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return OverexcLimX1BusinessDelegate
   */
  public static OverexcLimX1BusinessDelegate getOverexcLimX1Instance() {
    return (new OverexcLimX1BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createOverexcLimX1(CreateOverexcLimX1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getOverexcLimX1Id() == null) command.setOverexcLimX1Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateOverexcLimX1Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateOverexcLimX1Command of OverexcLimX1 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create OverexcLimX1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateOverexcLimX1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateOverexcLimX1(UpdateOverexcLimX1Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateOverexcLimX1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save OverexcLimX1 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteOverexcLimX1Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteOverexcLimX1Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteOverexcLimX1Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete OverexcLimX1 using Id = " + command.getOverexcLimX1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the OverexcLimX1 via OverexcLimX1FetchOneSummary
   *
   * @param summary OverexcLimX1FetchOneSummary
   * @return OverexcLimX1FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public OverexcLimX1 getOverexcLimX1(OverexcLimX1FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("OverexcLimX1FetchOneSummary arg cannot be null");

    OverexcLimX1 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a OverexcLimX1
      // --------------------------------------
      CompletableFuture<OverexcLimX1> futureEntity =
          queryGateway.query(
              new FindOverexcLimX1Query(new LoadOverexcLimX1Filter(summary.getOverexcLimX1Id())),
              ResponseTypes.instanceOf(OverexcLimX1.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate OverexcLimX1 with id " + summary.getOverexcLimX1Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all OverexcLimX1s
   *
   * @return List<OverexcLimX1>
   * @exception ProcessingException Thrown if any problems
   */
  public List<OverexcLimX1> getAllOverexcLimX1() throws ProcessingException {
    List<OverexcLimX1> list = null;

    try {
      CompletableFuture<List<OverexcLimX1>> futureList =
          queryGateway.query(
              new FindAllOverexcLimX1Query(),
              ResponseTypes.multipleInstancesOf(OverexcLimX1.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all OverexcLimX1";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Efd1 on OverexcLimX1
   *
   * @param command AssignEfd1ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignEfd1(AssignEfd1ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Efd1 on OverexcLimX1
   *
   * @param command UnAssignEfd1FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignEfd1(UnAssignEfd1FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd1 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efd2 on OverexcLimX1
   *
   * @param command AssignEfd2ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignEfd2(AssignEfd2ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Efd2 on OverexcLimX1
   *
   * @param command UnAssignEfd2FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignEfd2(UnAssignEfd2FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd2 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efd3 on OverexcLimX1
   *
   * @param command AssignEfd3ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignEfd3(AssignEfd3ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Efd3 on OverexcLimX1
   *
   * @param command UnAssignEfd3FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignEfd3(UnAssignEfd3FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd3 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efddes on OverexcLimX1
   *
   * @param command AssignEfddesToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignEfddes(AssignEfddesToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Efddes on OverexcLimX1
   *
   * @param command UnAssignEfddesFromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignEfddes(UnAssignEfddesFromOverexcLimX1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efddes on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efdrated on OverexcLimX1
   *
   * @param command AssignEfdratedToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignEfdrated(AssignEfdratedToOverexcLimX1Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Efdrated on OverexcLimX1
   *
   * @param command UnAssignEfdratedFromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignEfdrated(UnAssignEfdratedFromOverexcLimX1Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efdrated on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kmx on OverexcLimX1
   *
   * @param command AssignKmxToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignKmx(AssignKmxToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Kmx on OverexcLimX1
   *
   * @param command UnAssignKmxFromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignKmx(UnAssignKmxFromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kmx on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on OverexcLimX1
   *
   * @param command AssignT1ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign T1 on OverexcLimX1
   *
   * @param command UnAssignT1FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on OverexcLimX1
   *
   * @param command AssignT2ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign T2 on OverexcLimX1
   *
   * @param command UnAssignT2FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T3 on OverexcLimX1
   *
   * @param command AssignT3ToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignT3(AssignT3ToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign T3 on OverexcLimX1
   *
   * @param command UnAssignT3FromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignT3(UnAssignT3FromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T3 on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vlow on OverexcLimX1
   *
   * @param command AssignVlowToOverexcLimX1Command
   * @exception ProcessingException
   */
  public void assignVlow(AssignVlowToOverexcLimX1Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX1Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX1BusinessDelegate parentDelegate =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

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
   * unAssign Vlow on OverexcLimX1
   *
   * @param command UnAssignVlowFromOverexcLimX1Command
   * @exception ProcessingException
   */
  public void unAssignVlow(UnAssignVlowFromOverexcLimX1Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX1Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vlow on OverexcLimX1";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return OverexcLimX1
   */
  private OverexcLimX1 load(UUID id) throws ProcessingException {
    overexcLimX1 =
        OverexcLimX1BusinessDelegate.getOverexcLimX1Instance()
            .getOverexcLimX1(new OverexcLimX1FetchOneSummary(id));
    return overexcLimX1;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private OverexcLimX1 overexcLimX1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimX1BusinessDelegate.class.getName());
}
