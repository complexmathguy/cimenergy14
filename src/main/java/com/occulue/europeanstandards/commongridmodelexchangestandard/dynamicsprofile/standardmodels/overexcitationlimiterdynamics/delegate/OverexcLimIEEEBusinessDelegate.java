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
 * OverexcLimIEEE business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of OverexcLimIEEE related services in the case of a OverexcLimIEEE
 *       business related service failing.
 *   <li>Exposes a simpler, uniform OverexcLimIEEE interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill OverexcLimIEEE business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class OverexcLimIEEEBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public OverexcLimIEEEBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * OverexcLimIEEE Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return OverexcLimIEEEBusinessDelegate
   */
  public static OverexcLimIEEEBusinessDelegate getOverexcLimIEEEInstance() {
    return (new OverexcLimIEEEBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createOverexcLimIEEE(CreateOverexcLimIEEECommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getOverexcLimIEEEId() == null) command.setOverexcLimIEEEId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateOverexcLimIEEECommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateOverexcLimIEEECommand of OverexcLimIEEE is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create OverexcLimIEEE - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateOverexcLimIEEECommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateOverexcLimIEEE(UpdateOverexcLimIEEECommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateOverexcLimIEEECommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save OverexcLimIEEE - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteOverexcLimIEEECommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteOverexcLimIEEECommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteOverexcLimIEEECommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete OverexcLimIEEE using Id = " + command.getOverexcLimIEEEId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the OverexcLimIEEE via OverexcLimIEEEFetchOneSummary
   *
   * @param summary OverexcLimIEEEFetchOneSummary
   * @return OverexcLimIEEEFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public OverexcLimIEEE getOverexcLimIEEE(OverexcLimIEEEFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("OverexcLimIEEEFetchOneSummary arg cannot be null");

    OverexcLimIEEE entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a OverexcLimIEEE
      // --------------------------------------
      CompletableFuture<OverexcLimIEEE> futureEntity =
          queryGateway.query(
              new FindOverexcLimIEEEQuery(
                  new LoadOverexcLimIEEEFilter(summary.getOverexcLimIEEEId())),
              ResponseTypes.instanceOf(OverexcLimIEEE.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate OverexcLimIEEE with id " + summary.getOverexcLimIEEEId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all OverexcLimIEEEs
   *
   * @return List<OverexcLimIEEE>
   * @exception ProcessingException Thrown if any problems
   */
  public List<OverexcLimIEEE> getAllOverexcLimIEEE() throws ProcessingException {
    List<OverexcLimIEEE> list = null;

    try {
      CompletableFuture<List<OverexcLimIEEE>> futureList =
          queryGateway.query(
              new FindAllOverexcLimIEEEQuery(),
              ResponseTypes.multipleInstancesOf(OverexcLimIEEE.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all OverexcLimIEEE";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Hyst on OverexcLimIEEE
   *
   * @param command AssignHystToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignHyst(AssignHystToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Hyst on OverexcLimIEEE
   *
   * @param command UnAssignHystFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignHyst(UnAssignHystFromOverexcLimIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Hyst on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ifdlim on OverexcLimIEEE
   *
   * @param command AssignIfdlimToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignIfdlim(AssignIfdlimToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Ifdlim on OverexcLimIEEE
   *
   * @param command UnAssignIfdlimFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignIfdlim(UnAssignIfdlimFromOverexcLimIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ifdlim on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ifdmax on OverexcLimIEEE
   *
   * @param command AssignIfdmaxToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignIfdmax(AssignIfdmaxToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Ifdmax on OverexcLimIEEE
   *
   * @param command UnAssignIfdmaxFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignIfdmax(UnAssignIfdmaxFromOverexcLimIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ifdmax on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Itfpu on OverexcLimIEEE
   *
   * @param command AssignItfpuToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignItfpu(AssignItfpuToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Itfpu on OverexcLimIEEE
   *
   * @param command UnAssignItfpuFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignItfpu(UnAssignItfpuFromOverexcLimIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Itfpu on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kcd on OverexcLimIEEE
   *
   * @param command AssignKcdToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignKcd(AssignKcdToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Kcd on OverexcLimIEEE
   *
   * @param command UnAssignKcdFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignKcd(UnAssignKcdFromOverexcLimIEEECommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kcd on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kramp on OverexcLimIEEE
   *
   * @param command AssignKrampToOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void assignKramp(AssignKrampToOverexcLimIEEECommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOverexcLimIEEEId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    OverexcLimIEEEBusinessDelegate parentDelegate =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

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
   * unAssign Kramp on OverexcLimIEEE
   *
   * @param command UnAssignKrampFromOverexcLimIEEECommand
   * @exception ProcessingException
   */
  public void unAssignKramp(UnAssignKrampFromOverexcLimIEEECommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OverexcLimIEEEValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kramp on OverexcLimIEEE";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return OverexcLimIEEE
   */
  private OverexcLimIEEE load(UUID id) throws ProcessingException {
    overexcLimIEEE =
        OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance()
            .getOverexcLimIEEE(new OverexcLimIEEEFetchOneSummary(id));
    return overexcLimIEEE;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private OverexcLimIEEE overexcLimIEEE = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimIEEEBusinessDelegate.class.getName());
}
