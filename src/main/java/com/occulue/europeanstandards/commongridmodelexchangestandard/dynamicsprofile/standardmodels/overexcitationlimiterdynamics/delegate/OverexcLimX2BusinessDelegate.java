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
 * OverexcLimX2 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of OverexcLimX2 related services in the case of a OverexcLimX2
 *       business related service failing.
 *   <li>Exposes a simpler, uniform OverexcLimX2 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill OverexcLimX2 business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class OverexcLimX2BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public OverexcLimX2BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * OverexcLimX2 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return OverexcLimX2BusinessDelegate
   */
  public static OverexcLimX2BusinessDelegate getOverexcLimX2Instance() {
    return (new OverexcLimX2BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createOverexcLimX2(CreateOverexcLimX2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getOverexcLimX2Id() == null) command.setOverexcLimX2Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateOverexcLimX2Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateOverexcLimX2Command of OverexcLimX2 is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create OverexcLimX2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateOverexcLimX2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateOverexcLimX2(UpdateOverexcLimX2Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateOverexcLimX2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save OverexcLimX2 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteOverexcLimX2Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteOverexcLimX2Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteOverexcLimX2Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete OverexcLimX2 using Id = " + command.getOverexcLimX2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the OverexcLimX2 via OverexcLimX2FetchOneSummary
   *
   * @param summary OverexcLimX2FetchOneSummary
   * @return OverexcLimX2FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public OverexcLimX2 getOverexcLimX2(OverexcLimX2FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("OverexcLimX2FetchOneSummary arg cannot be null");

    OverexcLimX2 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a OverexcLimX2
      // --------------------------------------
      CompletableFuture<OverexcLimX2> futureEntity =
          queryGateway.query(
              new FindOverexcLimX2Query(new LoadOverexcLimX2Filter(summary.getOverexcLimX2Id())),
              ResponseTypes.instanceOf(OverexcLimX2.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate OverexcLimX2 with id " + summary.getOverexcLimX2Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all OverexcLimX2s
   *
   * @return List<OverexcLimX2>
   * @exception ProcessingException Thrown if any problems
   */
  public List<OverexcLimX2> getAllOverexcLimX2() throws ProcessingException {
    List<OverexcLimX2> list = null;

    try {
      CompletableFuture<List<OverexcLimX2>> futureList =
          queryGateway.query(
              new FindAllOverexcLimX2Query(),
              ResponseTypes.multipleInstancesOf(OverexcLimX2.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all OverexcLimX2";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Efd1 on OverexcLimX2
   *
   * @param command AssignEfd1ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignEfd1(AssignEfd1ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Efd1 on OverexcLimX2
   *
   * @param command UnAssignEfd1FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignEfd1(UnAssignEfd1FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd1 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efd2 on OverexcLimX2
   *
   * @param command AssignEfd2ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignEfd2(AssignEfd2ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Efd2 on OverexcLimX2
   *
   * @param command UnAssignEfd2FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignEfd2(UnAssignEfd2FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd2 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efd3 on OverexcLimX2
   *
   * @param command AssignEfd3ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignEfd3(AssignEfd3ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Efd3 on OverexcLimX2
   *
   * @param command UnAssignEfd3FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignEfd3(UnAssignEfd3FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efd3 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efddes on OverexcLimX2
   *
   * @param command AssignEfddesToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignEfddes(AssignEfddesToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Efddes on OverexcLimX2
   *
   * @param command UnAssignEfddesFromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignEfddes(UnAssignEfddesFromOverexcLimX2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efddes on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Efdrated on OverexcLimX2
   *
   * @param command AssignEfdratedToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignEfdrated(AssignEfdratedToOverexcLimX2Command command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Efdrated on OverexcLimX2
   *
   * @param command UnAssignEfdratedFromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignEfdrated(UnAssignEfdratedFromOverexcLimX2Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Efdrated on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kmx on OverexcLimX2
   *
   * @param command AssignKmxToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignKmx(AssignKmxToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Kmx on OverexcLimX2
   *
   * @param command UnAssignKmxFromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignKmx(UnAssignKmxFromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kmx on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign M on OverexcLimX2
   *
   * @param command AssignMToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignM(AssignMToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign M on OverexcLimX2
   *
   * @param command UnAssignMFromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignM(UnAssignMFromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign M on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on OverexcLimX2
   *
   * @param command AssignT1ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign T1 on OverexcLimX2
   *
   * @param command UnAssignT1FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on OverexcLimX2
   *
   * @param command AssignT2ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign T2 on OverexcLimX2
   *
   * @param command UnAssignT2FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T3 on OverexcLimX2
   *
   * @param command AssignT3ToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignT3(AssignT3ToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign T3 on OverexcLimX2
   *
   * @param command UnAssignT3FromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignT3(UnAssignT3FromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T3 on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vlow on OverexcLimX2
   *
   * @param command AssignVlowToOverexcLimX2Command
   * @exception ProcessingException
   */
  public void assignVlow(AssignVlowToOverexcLimX2Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimX2Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimX2BusinessDelegate parentDelegate =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

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
   * unAssign Vlow on OverexcLimX2
   *
   * @param command UnAssignVlowFromOverexcLimX2Command
   * @exception ProcessingException
   */
  public void unAssignVlow(UnAssignVlowFromOverexcLimX2Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimX2Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vlow on OverexcLimX2";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return OverexcLimX2
   */
  private OverexcLimX2 load(UUID id) throws ProcessingException {
    overexcLimX2 =
        OverexcLimX2BusinessDelegate.getOverexcLimX2Instance()
            .getOverexcLimX2(new OverexcLimX2FetchOneSummary(id));
    return overexcLimX2;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private OverexcLimX2 overexcLimX2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimX2BusinessDelegate.class.getName());
}
